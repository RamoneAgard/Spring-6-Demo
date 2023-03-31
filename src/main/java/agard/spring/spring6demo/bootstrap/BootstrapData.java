package agard.spring.spring6demo.bootstrap;

import agard.spring.spring6demo.domain.Author;
import agard.spring.spring6demo.domain.Book;
import agard.spring.spring6demo.domain.Publisher;
import agard.spring.spring6demo.repositories.AuthorRepository;
import agard.spring.spring6demo.repositories.BookRepository;
import agard.spring.spring6demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    // Fields //
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // Constructors //
    @Autowired
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    // Public Methods //
    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Publisher someP = new Publisher();
        someP.setAddress("some addy");
        someP.setCity("some city");
        someP.setZip("some zip");
        someP.setState("some state");
        someP.setPublisherName("Nice Name");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher somePSaved = publisherRepository.save(someP);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");


        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");


        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        dddSaved.setPublisher(somePSaved);
        dddSaved.getAuthors().add(ericSaved);
        somePSaved.getBooks().add(dddSaved);

        noEJBSaved.setPublisher(somePSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        somePSaved.getBooks().add(noEJBSaved);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        Book dddSavedAgain = bookRepository.save(dddSaved);
        Publisher somePSavedAgain = publisherRepository.save(somePSaved);
        Author ericSavedAgain = authorRepository.save(ericSaved);

        bookRepository.save(noEJBSaved);
        authorRepository.save(rodSaved);

        System.out.println("In bootstrap");
        System.out.printf("Author Count = %d %n", authorRepository.count());
        System.out.printf("Book Count = %d %n", bookRepository.count());
        System.out.printf("Publisher Count = %d %n", publisherRepository.count());
        System.out.printf("eric = %s %n", ericSavedAgain);
        System.out.printf("ddd = %s %n", dddSavedAgain);
        System.out.printf("someP = %s %n", somePSavedAgain);



    }
}
