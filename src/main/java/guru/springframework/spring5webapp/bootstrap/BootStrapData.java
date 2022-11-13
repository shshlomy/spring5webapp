package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author shlomy = new Author("Shlomo","Sheps");
        Book woo = new Book("Wizard of oz","1231243123");
        Author einshten = new Author("Albert", "Einstein");
        Book speedOfLight = new Book("Speed of light", "6657474");

        Publisher theKing = new Publisher("richard","tashor 3","netanya","israel","121212");


        shlomy.getBooks().add(woo);
        woo.getAuthors().add(shlomy);
        einshten.getBooks().add(speedOfLight);
        speedOfLight.getAuthors().add(einshten);

        authorRepository.save(shlomy);
        authorRepository.save(einshten);
        bookRepository.save(woo);
        bookRepository.save(speedOfLight);
        publisherRepository.save(theKing);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books is "+bookRepository.count());
        System.out.println("Number of publisher is "+publisherRepository.count());


    }
}
