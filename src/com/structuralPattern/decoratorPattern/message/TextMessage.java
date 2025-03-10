package com.structuralPattern.decoratorPattern.message;

public class TextMessage implements Message {

  String content;

  public TextMessage(String content) {
    this.content = content;
  }

  @Override
  public void setContent(String msg) {
    this.content = msg;
  }

  @Override
  public String getContent() {
    return this.content;
  }

  @Override
  public void send() {
    System.out.println("TextMessage: " + content);
  }

}
