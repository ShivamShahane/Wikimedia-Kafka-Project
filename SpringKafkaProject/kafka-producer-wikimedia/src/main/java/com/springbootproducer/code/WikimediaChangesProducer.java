package com.springbootproducer.code;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;



@Service
public class WikimediaChangesProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage() throws InterruptedException {
		
		String topic = "wikimedia_recentchange";
		
		//to read real time stream data form wikimedia, we use event source
		
		BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		
		
		// Create an EventSource builder with the URI
		EventSource.Builder eventSourceBuilder = new EventSource.Builder(URI.create(url));
		
		BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(eventHandler, eventSourceBuilder);
		
		BackgroundEventSource eventSource = builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
		
	}
	

}
