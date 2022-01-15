package de.dlz.core.pojo;

public abstract class Loader {
  public void init(){
    initManager();
    initListener();
    initCommands();
  }
  public abstract void initManager();
  public abstract void initListener();
  public abstract void initCommands();
  public abstract void shutdown();
}
