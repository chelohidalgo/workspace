package com.marcelohidalgo.myfirstollama.service;

import com.marcelohidalgo.myfirstollama.promptemplate.CountryCuisines;
import com.marcelohidalgo.myfirstollama.tools.WeatherTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
public class OllamaService {

    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;

    public OllamaService(ChatClient.Builder builder, ChatMemory chatMemory, EmbeddingModel embeddingModel, VectorStore vectorStore) {
        this.chatClient = builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
        this.embeddingModel = embeddingModel;
        this.vectorStore = vectorStore;
    }

    public ChatResponse generateAnswer(String question) {
        return chatClient.prompt(question).call().chatResponse();
    }

    public String getTravelGuidance(String city, String month, String language, String budget) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Welcome to the {city} travel guide! If you're visiting in {month}, here's what you can do: 
                1. Must-visit attractions. 
                2. Local cuisine you must try. 
                3. Useful phrases in {language}. 
                4. Tips for traveling on a {budget} budget. 
                Enjoy your trip!
                """);
        Prompt prompt = promptTemplate.create(Map.of("city", city, "month", month, "language", language, "budget", budget));

        return chatClient.prompt(prompt).call().chatResponse().getResult().getOutput().getText();
    }

    public CountryCuisines getCuisines(String country, String numCuisines, String language) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                You are an expert in traditional cuisines. Answer the question: 
                What is the traditional cuisine of {country}? 
                Return a list of {numCuisines} in {language}. 
                You provide information about a specific dish from a specific country. 
                Avoid giving information about fictional places. 
                If the country is fictional or non-existent return the country with out any cuisines.
                """);

        Prompt prompt = promptTemplate.create(Map.of("country", country, "numCuisines", numCuisines, "language", language));

        return chatClient.prompt(prompt).call().entity(CountryCuisines.class);
    }

    public String getInterview(String company, String jobTitle, String strength, String weakness) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Pretend you have are a experienced software engineer with more than 10 years of experience in IT, java
                is your main programming language, you have worked in different projects and different tech stack and
                you have an interview with the company {company} for the job position {jobTitle} and your strength is 
                {strength} and weakness is {weakness}, so your task is to provide me step by step the best tips for 
                this interview.
                """);
        Prompt prompt = promptTemplate.create(Map.of("company", company, "jobTitle", jobTitle, "strength", strength, "weakness", weakness));
        return chatClient.prompt(prompt).call().chatResponse().getResult().getOutput().getText();
    }

    public float[] embed(String text) {
        return embeddingModel.embed(text);
    }

    public List<Document> searchJobs(String query) {
        //return vectorStore.similaritySearch(query); //simplest implementation
        return vectorStore.similaritySearch(SearchRequest.builder().topK(3).query(query).build());
    }

    public String answer(String query) {
        return chatClient.prompt(query).advisors(QuestionAnswerAdvisor.builder(vectorStore).build()).call().content();
    }

    public String answerLegal(String query) {
        return chatClient.prompt(Prompt.builder().content(query).build()).advisors(QuestionAnswerAdvisor.builder(vectorStore).build()).call().content();
    }

    public String explainImage(String prompt, String path) {
        return chatClient.prompt().user(user -> user.text(prompt).media(MimeTypeUtils.IMAGE_JPEG, new FileSystemResource(path))).call().content();
    }

    public String callAgent(String query) {
        return chatClient.prompt(Prompt.builder().content(query).build()).tools(new WeatherTools()).call().content();
    }

    public Flux<String> streamAnswer(String query) {
        //return chatClient.prompt(query).advisors(QuestionAnswerAdvisor.builder(vectorStore).build()).stream().content();
        return chatClient.prompt(query).stream().content();
    }
}
