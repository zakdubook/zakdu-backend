package capstone.jakdu.Book.controller;

import capstone.jakdu.Book.object.dto.BookDownloadDto;
import capstone.jakdu.Book.service.BookDownloadService;
import capstone.jakdu.Common.response.ResponseDto;
import capstone.jakdu.Common.response.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/download")
@RequiredArgsConstructor
public class BookDownloadController {

    private final BookDownloadService bookDownloadService;

    @GetMapping("/pdf_test")
    public ResponseDto downloadPdfBookTest(@RequestParam("id") Long id) {
        // 유저 구매여부 확인

        BookDownloadDto bookDownloadDto = bookDownloadService.downloadBookTest(id);
        if(bookDownloadDto == null) {
            return new ResponseDto(StatusEnum.INTERNAL_SERVER_ERROR, "internal server error", null);
        }
        else {
            return new ResponseDto(StatusEnum.OK, "success", bookDownloadDto);
        }
    }

    @GetMapping("/pdf")
    public ResponseDto downloadPdfBook(@RequestParam("id") Long id) {
        // 유저 구매여부 확인, 유저 정보도 추가로 받아야 함
        BookDownloadDto bookDownloadDto = bookDownloadService.downloadBook(id);

        if(bookDownloadDto == null) {
            return new ResponseDto(StatusEnum.INTERNAL_SERVER_ERROR, "internal server error", null);
        }
        else {
            return new ResponseDto(StatusEnum.OK, "success", bookDownloadDto);
        }
    }
}
