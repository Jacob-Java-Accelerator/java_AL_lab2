package com.structuralPattern.decoratorPattern.message;

public class CompressionDecorator implements MessageDecorator {

  protected Message msg;

  public CompressionDecorator(Message msg) {
    this.msg = msg;
  }

  @Override
  public void setContent(String str) {
    msg.setContent("c->" + str.trim());
  }

  @Override
  public String getContent() {
    return msg.getContent();
  }

  @Override
  public void send() {
    System.out.println(getContent());
  }

}
