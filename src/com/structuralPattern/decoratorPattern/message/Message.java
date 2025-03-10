package com.structuralPattern.decoratorPattern.message;

public interface Message {
  void setContent(String msg);

  String getContent();

  void send();
}
