package com.kigen.notes.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;

/**
 * Author: kigen
 * Date: 22/09/2017.
 */

@Entity
public class Note {

  @PrimaryKey(autoGenerate = true)
  private long uuid;
  @ColumnInfo(name ="title")
  private String title;
  @ColumnInfo(name ="content")
  private  String content;
  @ColumnInfo(name ="author")
  private String author;
  @ColumnInfo(name ="time")
  private Date time;

  public Note(){
    this.time = new Date();
  }

  @Ignore
  public Note(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
    this.time = new Date();
  }

  public long getUuid() {
    return uuid;
  }

  public void setUuid(long uuid) {
    this.uuid = uuid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
