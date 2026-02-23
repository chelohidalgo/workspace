package com.marcelohidalgo.myfirstollama;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final VectorStore vectorStore;

    public DataInitializer(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void init() {
        TextReader jobReader = new TextReader(new ClassPathResource("job_listings.txt"));
        TokenTextSplitter tokenTextSplitter = new TokenTextSplitter(100, 100, 5, 1000, true);
        List<Document> documents = tokenTextSplitter.split(jobReader.get());
        vectorStore.add(documents);

        TextReader productReader = new TextReader(new ClassPathResource("product-data.txt"));
        List<Document> productDocuments = tokenTextSplitter.split(productReader.get());
        vectorStore.add(productDocuments);

        TextReader legalReader = new TextReader(new ClassPathResource("legal-data.txt"));
        List<Document> legalDocuments = tokenTextSplitter.split(legalReader.get());
        vectorStore.add(legalDocuments);
    }
}
