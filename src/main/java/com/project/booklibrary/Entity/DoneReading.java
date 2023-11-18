package com.project.booklibrary.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donereading")
public class DoneReading {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sl;
  @Column(name = "Book Name", nullable = false)
  private String bookname;
  @Column(name = "Author Name", nullable = false)
  private String authname;
  @Column(name = "Book's Summary")
  private String booksummary;

  public DoneReading() {
  }

  public DoneReading(String bookname, String authname, String booksummary) {
    this.bookname = bookname;
    this.authname = authname;
    this.booksummary = booksummary;
  }

  public long getSl() {
    return sl;
  }

  public void setSl(long sl) {
    this.sl = sl;
  }

  public String getBookname() {
    return bookname;
  }

  public void setBookname(String bookname) {
    this.bookname = bookname;
  }

  public String getAuthname() {
    return authname;
  }

  public void setAuthname(String authname) {
    this.authname = authname;
  }

  public String getBooksummary() {
    return booksummary;
  }

  public void setBooksummary(String booksummary) {
    this.booksummary = booksummary;
  }

}
