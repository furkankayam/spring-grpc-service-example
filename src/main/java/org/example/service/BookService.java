package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.BookDto;
import org.example.dto.mapper.BookMapper;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookDto createBook(BookDto bookRequestDto) {
        Book book = bookMapper.toBook(bookRequestDto);
        bookRepository.save(book);
        return bookMapper.toBookDto(book);
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toBookDto)
                .toList();
    }
}
