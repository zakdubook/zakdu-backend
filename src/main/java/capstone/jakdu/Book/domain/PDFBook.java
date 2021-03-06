package capstone.jakdu.Book.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import capstone.jakdu.Book.object.dto.BookRegisterDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class PDFBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    List<PDFKey> keys = new ArrayList<>();


    private String category;
    private String name;
    private String author;
    private String publisher;
    private Date pubDate;
    @Column(length = 2000)
    private String intro;
    private Long price;
    private int realStartPage;
    private int pdfPageCount;
    private String type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private FileStream bookFile;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private FileStream bookCover;


    public PDFBook(String category,
                   String name,
                   String author,
                   String publisher,
                   Date pubDate,
                   String intro,
                   Long price,
                   int realStartPage,
                    int pdfPageCount,
                    FileStream bookFile,
                    FileStream bookCover) {

        this.category = category;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.intro = intro;
        this.price = price;
        this.realStartPage = realStartPage;
        this.pdfPageCount = pdfPageCount;
        this.bookFile = bookFile;
        this.bookCover = bookCover;
        this.type = "pdf";
    }


    public static PDFBook of(String category,
                             String name,
                             String author,
                             String publisher,
                             Date pubDate,
                             String intro,
                             Long price,
                             int realStartPage,
                             int pdfPageCount,
                             FileStream bookFile,
                             FileStream bookCover) {


        return new PDFBook(category, name, author, publisher, pubDate, intro, price, realStartPage, pdfPageCount, bookFile, bookCover);
    }


    // ??? ??????, ??????, ???????????? ??????


    // ???????????? ????????? ?????? ??????

    // ?????? ?????? => start -  end page ?????? (?????? ?????????)

    // ????????? ?????? => pdf ????????? => ?????? ???????????? ????????? ?????? ??????
    // ?????? ????????? ????????? ?????? ?????????. => pdf ????????? / ??? ???????????? ?????? ???????????? pdf ???????????? ???????????????

    // ???????????? ????????? ?????? => ??? ?????????????????? => ??? ????????? ?????? ??????
    // ??? ?????? . pdf ????????? ??????.

     // ?????? -> ??????
    // List<key> keys;
    //toc


    // 1. ??? ?????? api ?????? ?????? ?????? ?????? ?????? <???>
    // 2. ?????? ??? ??? ?????? =>  ?????? ?????? ?????? ?????? ??????  =>  ?????? api

    // 3. ????????? ????????? ?????? ?????? ?????? -> ?????? ??? ??? ????????? ??????
    // 4  ?????? ???????????? => ??????????????? ??? ????????? ?????? ????????? ?????? ?????? ?????????????????? ?????? ????????? ????????? ?????????????
    // 5. async storage ?????? ????????? ?????? ??????.




}
