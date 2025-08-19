package org.example.dto.mapper;

import org.example.dto.BookDto;
import org.example.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface BookMapper {

    public abstract BookDto toBookDto(Book book);
    public abstract Book toBook(BookDto bookDto);
}
