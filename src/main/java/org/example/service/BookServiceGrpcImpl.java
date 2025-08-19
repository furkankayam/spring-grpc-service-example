package org.example.service;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.example.dto.BookDto;
import org.example.grpc.BookRequest;
import org.example.grpc.BookResponse;
import org.example.grpc.BookServiceGrpc;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class BookServiceGrpcImpl extends BookServiceGrpc.BookServiceImplBase {

    private final BookService bookService;

    @Override
    public void createBook(BookRequest request, StreamObserver<BookResponse> responseObserver) {
        BookDto bookDto = BookDto.builder()
                .author(request.getAuthor())
                .title(request.getTitle())
                .page(request.getPage())
                .build();
        bookService.createBook(bookDto);
        responseObserver.onNext(BookResponse.newBuilder()
                .setTitle(request.getTitle())
                .setAuthor(request.getAuthor())
                .setPage(request.getPage())
                .build());
        responseObserver.onCompleted();
    }
}
