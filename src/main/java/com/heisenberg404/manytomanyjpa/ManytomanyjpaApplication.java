package com.heisenberg404.manytomanyjpa;

import com.heisenberg404.manytomanyjpa.model.Book;
import com.heisenberg404.manytomanyjpa.model.BookPublisher;
import com.heisenberg404.manytomanyjpa.model.Publisher;
import com.heisenberg404.manytomanyjpa.repository.BookRepository;
import com.heisenberg404.manytomanyjpa.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootApplication
public class ManytomanyjpaApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ManytomanyjpaApplication.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyjpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		Book bookA = new Book("El señor de los anillos");
		Book bookB = new Book("Harry potter");
		Book bookC = new Book("Cancion de hielo y fuego");
		Book bookD = new Book("El psicoanalista");

		Publisher publisherA = new Publisher("JKR");
		Publisher publisherB = new Publisher("KRM");
		Publisher publisherC = new Publisher("JKZ");
		Publisher publisherD = new Publisher("CHF");

		BookPublisher bookPublisherA = new BookPublisher();
		bookPublisherA.setBook(bookA);
		bookPublisherA.setPublisher(publisherA);
		bookPublisherA.setPublishedDate(new Date());
		BookPublisher bookPublisherB = new BookPublisher();
		bookPublisherB.setBook(bookB);
		bookPublisherB.setPublisher(publisherB);
		bookPublisherB.setPublishedDate(new Date());
		BookPublisher bookPublisherC = new BookPublisher();
		bookPublisherC.setBook(bookC);
		bookPublisherC.setPublisher(publisherC);
		bookPublisherC.setPublishedDate(new Date());
		BookPublisher bookPublisherD = new BookPublisher();
		bookPublisherD.setBook(bookD);
		bookPublisherD.setPublisher(publisherD);
		bookPublisherD.setPublishedDate(new Date());


		bookA.getBookPublishers().add(bookPublisherA);
		bookB.getBookPublishers().add(bookPublisherB);
		bookC.getBookPublishers().add(bookPublisherC);
		bookD.getBookPublishers().add(bookPublisherD);

		publisherRepository.save(publisherA);
		publisherRepository.save(publisherB);
		publisherRepository.save(publisherC);
		publisherRepository.save(publisherD);

		bookRepository.save(bookA);
		bookRepository.save(bookB);
		bookRepository.save(bookC);
		bookRepository.save(bookD);

		// test
		System.out.println(bookA.getBookPublishers().size());

		// update
		//bookA.getBookPublishers().remove(bookPublisher);
		//bookRepository.save(bookA);

		// test
		System.out.println(bookA.getBookPublishers().size());
	}
}
