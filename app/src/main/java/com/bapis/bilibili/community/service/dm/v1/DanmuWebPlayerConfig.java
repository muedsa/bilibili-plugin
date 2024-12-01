// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * <pre>
 * 具体数值意义 https://info.bilibili.co/pages/viewpage.action?pageId=114161867
 * </pre>
 *
 * Protobuf type {@code bilibili.community.service.dm.v1.DanmuWebPlayerConfig}
 */
public  final class DanmuWebPlayerConfig extends
    com.google.protobuf.GeneratedMessageLite<
        DanmuWebPlayerConfig, DanmuWebPlayerConfig.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.DanmuWebPlayerConfig)
    DanmuWebPlayerConfigOrBuilder {
  private DanmuWebPlayerConfig() {
    fontfamily_ = "";
    drawType_ = "";
  }
  public static final int DM_SWITCH_FIELD_NUMBER = 1;
  private boolean dmSwitch_;
  /**
   * <code>bool dm_switch = 1;</code>
   * @return The dmSwitch.
   */
  @java.lang.Override
  public boolean getDmSwitch() {
    return dmSwitch_;
  }
  /**
   * <code>bool dm_switch = 1;</code>
   * @param value The dmSwitch to set.
   */
  private void setDmSwitch(boolean value) {
    
    dmSwitch_ = value;
  }
  /**
   * <code>bool dm_switch = 1;</code>
   */
  private void clearDmSwitch() {

    dmSwitch_ = false;
  }

  public static final int AI_SWITCH_FIELD_NUMBER = 2;
  private boolean aiSwitch_;
  /**
   * <code>bool ai_switch = 2;</code>
   * @return The aiSwitch.
   */
  @java.lang.Override
  public boolean getAiSwitch() {
    return aiSwitch_;
  }
  /**
   * <code>bool ai_switch = 2;</code>
   * @param value The aiSwitch to set.
   */
  private void setAiSwitch(boolean value) {
    
    aiSwitch_ = value;
  }
  /**
   * <code>bool ai_switch = 2;</code>
   */
  private void clearAiSwitch() {

    aiSwitch_ = false;
  }

  public static final int AI_LEVEL_FIELD_NUMBER = 3;
  private int aiLevel_;
  /**
   * <code>int32 ai_level = 3;</code>
   * @return The aiLevel.
   */
  @java.lang.Override
  public int getAiLevel() {
    return aiLevel_;
  }
  /**
   * <code>int32 ai_level = 3;</code>
   * @param value The aiLevel to set.
   */
  private void setAiLevel(int value) {
    
    aiLevel_ = value;
  }
  /**
   * <code>int32 ai_level = 3;</code>
   */
  private void clearAiLevel() {

    aiLevel_ = 0;
  }

  public static final int BLOCKTOP_FIELD_NUMBER = 4;
  private boolean blocktop_;
  /**
   * <code>bool blocktop = 4;</code>
   * @return The blocktop.
   */
  @java.lang.Override
  public boolean getBlocktop() {
    return blocktop_;
  }
  /**
   * <code>bool blocktop = 4;</code>
   * @param value The blocktop to set.
   */
  private void setBlocktop(boolean value) {
    
    blocktop_ = value;
  }
  /**
   * <code>bool blocktop = 4;</code>
   */
  private void clearBlocktop() {

    blocktop_ = false;
  }

  public static final int BLOCKSCROLL_FIELD_NUMBER = 5;
  private boolean blockscroll_;
  /**
   * <code>bool blockscroll = 5;</code>
   * @return The blockscroll.
   */
  @java.lang.Override
  public boolean getBlockscroll() {
    return blockscroll_;
  }
  /**
   * <code>bool blockscroll = 5;</code>
   * @param value The blockscroll to set.
   */
  private void setBlockscroll(boolean value) {
    
    blockscroll_ = value;
  }
  /**
   * <code>bool blockscroll = 5;</code>
   */
  private void clearBlockscroll() {

    blockscroll_ = false;
  }

  public static final int BLOCKBOTTOM_FIELD_NUMBER = 6;
  private boolean blockbottom_;
  /**
   * <code>bool blockbottom = 6;</code>
   * @return The blockbottom.
   */
  @java.lang.Override
  public boolean getBlockbottom() {
    return blockbottom_;
  }
  /**
   * <code>bool blockbottom = 6;</code>
   * @param value The blockbottom to set.
   */
  private void setBlockbottom(boolean value) {
    
    blockbottom_ = value;
  }
  /**
   * <code>bool blockbottom = 6;</code>
   */
  private void clearBlockbottom() {

    blockbottom_ = false;
  }

  public static final int BLOCKCOLOR_FIELD_NUMBER = 7;
  private boolean blockcolor_;
  /**
   * <code>bool blockcolor = 7;</code>
   * @return The blockcolor.
   */
  @java.lang.Override
  public boolean getBlockcolor() {
    return blockcolor_;
  }
  /**
   * <code>bool blockcolor = 7;</code>
   * @param value The blockcolor to set.
   */
  private void setBlockcolor(boolean value) {
    
    blockcolor_ = value;
  }
  /**
   * <code>bool blockcolor = 7;</code>
   */
  private void clearBlockcolor() {

    blockcolor_ = false;
  }

  public static final int BLOCKSPECIAL_FIELD_NUMBER = 8;
  private boolean blockspecial_;
  /**
   * <code>bool blockspecial = 8;</code>
   * @return The blockspecial.
   */
  @java.lang.Override
  public boolean getBlockspecial() {
    return blockspecial_;
  }
  /**
   * <code>bool blockspecial = 8;</code>
   * @param value The blockspecial to set.
   */
  private void setBlockspecial(boolean value) {
    
    blockspecial_ = value;
  }
  /**
   * <code>bool blockspecial = 8;</code>
   */
  private void clearBlockspecial() {

    blockspecial_ = false;
  }

  public static final int PREVENTSHADE_FIELD_NUMBER = 9;
  private boolean preventshade_;
  /**
   * <code>bool preventshade = 9;</code>
   * @return The preventshade.
   */
  @java.lang.Override
  public boolean getPreventshade() {
    return preventshade_;
  }
  /**
   * <code>bool preventshade = 9;</code>
   * @param value The preventshade to set.
   */
  private void setPreventshade(boolean value) {
    
    preventshade_ = value;
  }
  /**
   * <code>bool preventshade = 9;</code>
   */
  private void clearPreventshade() {

    preventshade_ = false;
  }

  public static final int DMASK_FIELD_NUMBER = 10;
  private boolean dmask_;
  /**
   * <code>bool dmask = 10;</code>
   * @return The dmask.
   */
  @java.lang.Override
  public boolean getDmask() {
    return dmask_;
  }
  /**
   * <code>bool dmask = 10;</code>
   * @param value The dmask to set.
   */
  private void setDmask(boolean value) {
    
    dmask_ = value;
  }
  /**
   * <code>bool dmask = 10;</code>
   */
  private void clearDmask() {

    dmask_ = false;
  }

  public static final int OPACITY_FIELD_NUMBER = 11;
  private float opacity_;
  /**
   * <code>float opacity = 11;</code>
   * @return The opacity.
   */
  @java.lang.Override
  public float getOpacity() {
    return opacity_;
  }
  /**
   * <code>float opacity = 11;</code>
   * @param value The opacity to set.
   */
  private void setOpacity(float value) {
    
    opacity_ = value;
  }
  /**
   * <code>float opacity = 11;</code>
   */
  private void clearOpacity() {

    opacity_ = 0F;
  }

  public static final int DMAREA_FIELD_NUMBER = 12;
  private int dmarea_;
  /**
   * <code>int32 dmarea = 12;</code>
   * @return The dmarea.
   */
  @java.lang.Override
  public int getDmarea() {
    return dmarea_;
  }
  /**
   * <code>int32 dmarea = 12;</code>
   * @param value The dmarea to set.
   */
  private void setDmarea(int value) {
    
    dmarea_ = value;
  }
  /**
   * <code>int32 dmarea = 12;</code>
   */
  private void clearDmarea() {

    dmarea_ = 0;
  }

  public static final int SPEEDPLUS_FIELD_NUMBER = 13;
  private float speedplus_;
  /**
   * <code>float speedplus = 13;</code>
   * @return The speedplus.
   */
  @java.lang.Override
  public float getSpeedplus() {
    return speedplus_;
  }
  /**
   * <code>float speedplus = 13;</code>
   * @param value The speedplus to set.
   */
  private void setSpeedplus(float value) {
    
    speedplus_ = value;
  }
  /**
   * <code>float speedplus = 13;</code>
   */
  private void clearSpeedplus() {

    speedplus_ = 0F;
  }

  public static final int FONTSIZE_FIELD_NUMBER = 14;
  private float fontsize_;
  /**
   * <code>float fontsize = 14;</code>
   * @return The fontsize.
   */
  @java.lang.Override
  public float getFontsize() {
    return fontsize_;
  }
  /**
   * <code>float fontsize = 14;</code>
   * @param value The fontsize to set.
   */
  private void setFontsize(float value) {
    
    fontsize_ = value;
  }
  /**
   * <code>float fontsize = 14;</code>
   */
  private void clearFontsize() {

    fontsize_ = 0F;
  }

  public static final int SCREENSYNC_FIELD_NUMBER = 15;
  private boolean screensync_;
  /**
   * <code>bool screensync = 15;</code>
   * @return The screensync.
   */
  @java.lang.Override
  public boolean getScreensync() {
    return screensync_;
  }
  /**
   * <code>bool screensync = 15;</code>
   * @param value The screensync to set.
   */
  private void setScreensync(boolean value) {
    
    screensync_ = value;
  }
  /**
   * <code>bool screensync = 15;</code>
   */
  private void clearScreensync() {

    screensync_ = false;
  }

  public static final int SPEEDSYNC_FIELD_NUMBER = 16;
  private boolean speedsync_;
  /**
   * <code>bool speedsync = 16;</code>
   * @return The speedsync.
   */
  @java.lang.Override
  public boolean getSpeedsync() {
    return speedsync_;
  }
  /**
   * <code>bool speedsync = 16;</code>
   * @param value The speedsync to set.
   */
  private void setSpeedsync(boolean value) {
    
    speedsync_ = value;
  }
  /**
   * <code>bool speedsync = 16;</code>
   */
  private void clearSpeedsync() {

    speedsync_ = false;
  }

  public static final int FONTFAMILY_FIELD_NUMBER = 17;
  private java.lang.String fontfamily_;
  /**
   * <code>string fontfamily = 17;</code>
   * @return The fontfamily.
   */
  @java.lang.Override
  public java.lang.String getFontfamily() {
    return fontfamily_;
  }
  /**
   * <code>string fontfamily = 17;</code>
   * @return The bytes for fontfamily.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFontfamilyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(fontfamily_);
  }
  /**
   * <code>string fontfamily = 17;</code>
   * @param value The fontfamily to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setFontfamily(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    fontfamily_ = value;
  }
  /**
   * <code>string fontfamily = 17;</code>
   */
  private void clearFontfamily() {

    fontfamily_ = getDefaultInstance().getFontfamily();
  }
  /**
   * <code>string fontfamily = 17;</code>
   * @param value The bytes for fontfamily to set.
   */
  private void setFontfamilyBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    fontfamily_ = value.toStringUtf8();

  }

  public static final int BOLD_FIELD_NUMBER = 18;
  private boolean bold_;
  /**
   * <code>bool bold = 18;</code>
   * @return The bold.
   */
  @java.lang.Override
  public boolean getBold() {
    return bold_;
  }
  /**
   * <code>bool bold = 18;</code>
   * @param value The bold to set.
   */
  private void setBold(boolean value) {
    
    bold_ = value;
  }
  /**
   * <code>bool bold = 18;</code>
   */
  private void clearBold() {

    bold_ = false;
  }

  public static final int FONTBORDER_FIELD_NUMBER = 19;
  private int fontborder_;
  /**
   * <code>int32 fontborder = 19;</code>
   * @return The fontborder.
   */
  @java.lang.Override
  public int getFontborder() {
    return fontborder_;
  }
  /**
   * <code>int32 fontborder = 19;</code>
   * @param value The fontborder to set.
   */
  private void setFontborder(int value) {
    
    fontborder_ = value;
  }
  /**
   * <code>int32 fontborder = 19;</code>
   */
  private void clearFontborder() {

    fontborder_ = 0;
  }

  public static final int DRAW_TYPE_FIELD_NUMBER = 20;
  private java.lang.String drawType_;
  /**
   * <code>string draw_type = 20;</code>
   * @return The drawType.
   */
  @java.lang.Override
  public java.lang.String getDrawType() {
    return drawType_;
  }
  /**
   * <code>string draw_type = 20;</code>
   * @return The bytes for drawType.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDrawTypeBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(drawType_);
  }
  /**
   * <code>string draw_type = 20;</code>
   * @param value The drawType to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setDrawType(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    drawType_ = value;
  }
  /**
   * <code>string draw_type = 20;</code>
   */
  private void clearDrawType() {

    drawType_ = getDefaultInstance().getDrawType();
  }
  /**
   * <code>string draw_type = 20;</code>
   * @param value The bytes for drawType to set.
   */
  private void setDrawTypeBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    drawType_ = value.toStringUtf8();

  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * 具体数值意义 https://info.bilibili.co/pages/viewpage.action?pageId=114161867
   * </pre>
   *
   * Protobuf type {@code bilibili.community.service.dm.v1.DanmuWebPlayerConfig}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.DanmuWebPlayerConfig)
      com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfigOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>bool dm_switch = 1;</code>
     * @return The dmSwitch.
     */
    @java.lang.Override
    public boolean getDmSwitch() {
      return instance.getDmSwitch();
    }
    /**
     * <code>bool dm_switch = 1;</code>
     * @param value The dmSwitch to set.
     * @return This builder for chaining.
     */
    public Builder setDmSwitch(boolean value) {
      copyOnWrite();
      instance.setDmSwitch(value);
      return this;
    }
    /**
     * <code>bool dm_switch = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDmSwitch() {
      copyOnWrite();
      instance.clearDmSwitch();
      return this;
    }

    /**
     * <code>bool ai_switch = 2;</code>
     * @return The aiSwitch.
     */
    @java.lang.Override
    public boolean getAiSwitch() {
      return instance.getAiSwitch();
    }
    /**
     * <code>bool ai_switch = 2;</code>
     * @param value The aiSwitch to set.
     * @return This builder for chaining.
     */
    public Builder setAiSwitch(boolean value) {
      copyOnWrite();
      instance.setAiSwitch(value);
      return this;
    }
    /**
     * <code>bool ai_switch = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAiSwitch() {
      copyOnWrite();
      instance.clearAiSwitch();
      return this;
    }

    /**
     * <code>int32 ai_level = 3;</code>
     * @return The aiLevel.
     */
    @java.lang.Override
    public int getAiLevel() {
      return instance.getAiLevel();
    }
    /**
     * <code>int32 ai_level = 3;</code>
     * @param value The aiLevel to set.
     * @return This builder for chaining.
     */
    public Builder setAiLevel(int value) {
      copyOnWrite();
      instance.setAiLevel(value);
      return this;
    }
    /**
     * <code>int32 ai_level = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAiLevel() {
      copyOnWrite();
      instance.clearAiLevel();
      return this;
    }

    /**
     * <code>bool blocktop = 4;</code>
     * @return The blocktop.
     */
    @java.lang.Override
    public boolean getBlocktop() {
      return instance.getBlocktop();
    }
    /**
     * <code>bool blocktop = 4;</code>
     * @param value The blocktop to set.
     * @return This builder for chaining.
     */
    public Builder setBlocktop(boolean value) {
      copyOnWrite();
      instance.setBlocktop(value);
      return this;
    }
    /**
     * <code>bool blocktop = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlocktop() {
      copyOnWrite();
      instance.clearBlocktop();
      return this;
    }

    /**
     * <code>bool blockscroll = 5;</code>
     * @return The blockscroll.
     */
    @java.lang.Override
    public boolean getBlockscroll() {
      return instance.getBlockscroll();
    }
    /**
     * <code>bool blockscroll = 5;</code>
     * @param value The blockscroll to set.
     * @return This builder for chaining.
     */
    public Builder setBlockscroll(boolean value) {
      copyOnWrite();
      instance.setBlockscroll(value);
      return this;
    }
    /**
     * <code>bool blockscroll = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlockscroll() {
      copyOnWrite();
      instance.clearBlockscroll();
      return this;
    }

    /**
     * <code>bool blockbottom = 6;</code>
     * @return The blockbottom.
     */
    @java.lang.Override
    public boolean getBlockbottom() {
      return instance.getBlockbottom();
    }
    /**
     * <code>bool blockbottom = 6;</code>
     * @param value The blockbottom to set.
     * @return This builder for chaining.
     */
    public Builder setBlockbottom(boolean value) {
      copyOnWrite();
      instance.setBlockbottom(value);
      return this;
    }
    /**
     * <code>bool blockbottom = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlockbottom() {
      copyOnWrite();
      instance.clearBlockbottom();
      return this;
    }

    /**
     * <code>bool blockcolor = 7;</code>
     * @return The blockcolor.
     */
    @java.lang.Override
    public boolean getBlockcolor() {
      return instance.getBlockcolor();
    }
    /**
     * <code>bool blockcolor = 7;</code>
     * @param value The blockcolor to set.
     * @return This builder for chaining.
     */
    public Builder setBlockcolor(boolean value) {
      copyOnWrite();
      instance.setBlockcolor(value);
      return this;
    }
    /**
     * <code>bool blockcolor = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlockcolor() {
      copyOnWrite();
      instance.clearBlockcolor();
      return this;
    }

    /**
     * <code>bool blockspecial = 8;</code>
     * @return The blockspecial.
     */
    @java.lang.Override
    public boolean getBlockspecial() {
      return instance.getBlockspecial();
    }
    /**
     * <code>bool blockspecial = 8;</code>
     * @param value The blockspecial to set.
     * @return This builder for chaining.
     */
    public Builder setBlockspecial(boolean value) {
      copyOnWrite();
      instance.setBlockspecial(value);
      return this;
    }
    /**
     * <code>bool blockspecial = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlockspecial() {
      copyOnWrite();
      instance.clearBlockspecial();
      return this;
    }

    /**
     * <code>bool preventshade = 9;</code>
     * @return The preventshade.
     */
    @java.lang.Override
    public boolean getPreventshade() {
      return instance.getPreventshade();
    }
    /**
     * <code>bool preventshade = 9;</code>
     * @param value The preventshade to set.
     * @return This builder for chaining.
     */
    public Builder setPreventshade(boolean value) {
      copyOnWrite();
      instance.setPreventshade(value);
      return this;
    }
    /**
     * <code>bool preventshade = 9;</code>
     * @return This builder for chaining.
     */
    public Builder clearPreventshade() {
      copyOnWrite();
      instance.clearPreventshade();
      return this;
    }

    /**
     * <code>bool dmask = 10;</code>
     * @return The dmask.
     */
    @java.lang.Override
    public boolean getDmask() {
      return instance.getDmask();
    }
    /**
     * <code>bool dmask = 10;</code>
     * @param value The dmask to set.
     * @return This builder for chaining.
     */
    public Builder setDmask(boolean value) {
      copyOnWrite();
      instance.setDmask(value);
      return this;
    }
    /**
     * <code>bool dmask = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearDmask() {
      copyOnWrite();
      instance.clearDmask();
      return this;
    }

    /**
     * <code>float opacity = 11;</code>
     * @return The opacity.
     */
    @java.lang.Override
    public float getOpacity() {
      return instance.getOpacity();
    }
    /**
     * <code>float opacity = 11;</code>
     * @param value The opacity to set.
     * @return This builder for chaining.
     */
    public Builder setOpacity(float value) {
      copyOnWrite();
      instance.setOpacity(value);
      return this;
    }
    /**
     * <code>float opacity = 11;</code>
     * @return This builder for chaining.
     */
    public Builder clearOpacity() {
      copyOnWrite();
      instance.clearOpacity();
      return this;
    }

    /**
     * <code>int32 dmarea = 12;</code>
     * @return The dmarea.
     */
    @java.lang.Override
    public int getDmarea() {
      return instance.getDmarea();
    }
    /**
     * <code>int32 dmarea = 12;</code>
     * @param value The dmarea to set.
     * @return This builder for chaining.
     */
    public Builder setDmarea(int value) {
      copyOnWrite();
      instance.setDmarea(value);
      return this;
    }
    /**
     * <code>int32 dmarea = 12;</code>
     * @return This builder for chaining.
     */
    public Builder clearDmarea() {
      copyOnWrite();
      instance.clearDmarea();
      return this;
    }

    /**
     * <code>float speedplus = 13;</code>
     * @return The speedplus.
     */
    @java.lang.Override
    public float getSpeedplus() {
      return instance.getSpeedplus();
    }
    /**
     * <code>float speedplus = 13;</code>
     * @param value The speedplus to set.
     * @return This builder for chaining.
     */
    public Builder setSpeedplus(float value) {
      copyOnWrite();
      instance.setSpeedplus(value);
      return this;
    }
    /**
     * <code>float speedplus = 13;</code>
     * @return This builder for chaining.
     */
    public Builder clearSpeedplus() {
      copyOnWrite();
      instance.clearSpeedplus();
      return this;
    }

    /**
     * <code>float fontsize = 14;</code>
     * @return The fontsize.
     */
    @java.lang.Override
    public float getFontsize() {
      return instance.getFontsize();
    }
    /**
     * <code>float fontsize = 14;</code>
     * @param value The fontsize to set.
     * @return This builder for chaining.
     */
    public Builder setFontsize(float value) {
      copyOnWrite();
      instance.setFontsize(value);
      return this;
    }
    /**
     * <code>float fontsize = 14;</code>
     * @return This builder for chaining.
     */
    public Builder clearFontsize() {
      copyOnWrite();
      instance.clearFontsize();
      return this;
    }

    /**
     * <code>bool screensync = 15;</code>
     * @return The screensync.
     */
    @java.lang.Override
    public boolean getScreensync() {
      return instance.getScreensync();
    }
    /**
     * <code>bool screensync = 15;</code>
     * @param value The screensync to set.
     * @return This builder for chaining.
     */
    public Builder setScreensync(boolean value) {
      copyOnWrite();
      instance.setScreensync(value);
      return this;
    }
    /**
     * <code>bool screensync = 15;</code>
     * @return This builder for chaining.
     */
    public Builder clearScreensync() {
      copyOnWrite();
      instance.clearScreensync();
      return this;
    }

    /**
     * <code>bool speedsync = 16;</code>
     * @return The speedsync.
     */
    @java.lang.Override
    public boolean getSpeedsync() {
      return instance.getSpeedsync();
    }
    /**
     * <code>bool speedsync = 16;</code>
     * @param value The speedsync to set.
     * @return This builder for chaining.
     */
    public Builder setSpeedsync(boolean value) {
      copyOnWrite();
      instance.setSpeedsync(value);
      return this;
    }
    /**
     * <code>bool speedsync = 16;</code>
     * @return This builder for chaining.
     */
    public Builder clearSpeedsync() {
      copyOnWrite();
      instance.clearSpeedsync();
      return this;
    }

    /**
     * <code>string fontfamily = 17;</code>
     * @return The fontfamily.
     */
    @java.lang.Override
    public java.lang.String getFontfamily() {
      return instance.getFontfamily();
    }
    /**
     * <code>string fontfamily = 17;</code>
     * @return The bytes for fontfamily.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getFontfamilyBytes() {
      return instance.getFontfamilyBytes();
    }
    /**
     * <code>string fontfamily = 17;</code>
     * @param value The fontfamily to set.
     * @return This builder for chaining.
     */
    public Builder setFontfamily(
        java.lang.String value) {
      copyOnWrite();
      instance.setFontfamily(value);
      return this;
    }
    /**
     * <code>string fontfamily = 17;</code>
     * @return This builder for chaining.
     */
    public Builder clearFontfamily() {
      copyOnWrite();
      instance.clearFontfamily();
      return this;
    }
    /**
     * <code>string fontfamily = 17;</code>
     * @param value The bytes for fontfamily to set.
     * @return This builder for chaining.
     */
    public Builder setFontfamilyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setFontfamilyBytes(value);
      return this;
    }

    /**
     * <code>bool bold = 18;</code>
     * @return The bold.
     */
    @java.lang.Override
    public boolean getBold() {
      return instance.getBold();
    }
    /**
     * <code>bool bold = 18;</code>
     * @param value The bold to set.
     * @return This builder for chaining.
     */
    public Builder setBold(boolean value) {
      copyOnWrite();
      instance.setBold(value);
      return this;
    }
    /**
     * <code>bool bold = 18;</code>
     * @return This builder for chaining.
     */
    public Builder clearBold() {
      copyOnWrite();
      instance.clearBold();
      return this;
    }

    /**
     * <code>int32 fontborder = 19;</code>
     * @return The fontborder.
     */
    @java.lang.Override
    public int getFontborder() {
      return instance.getFontborder();
    }
    /**
     * <code>int32 fontborder = 19;</code>
     * @param value The fontborder to set.
     * @return This builder for chaining.
     */
    public Builder setFontborder(int value) {
      copyOnWrite();
      instance.setFontborder(value);
      return this;
    }
    /**
     * <code>int32 fontborder = 19;</code>
     * @return This builder for chaining.
     */
    public Builder clearFontborder() {
      copyOnWrite();
      instance.clearFontborder();
      return this;
    }

    /**
     * <code>string draw_type = 20;</code>
     * @return The drawType.
     */
    @java.lang.Override
    public java.lang.String getDrawType() {
      return instance.getDrawType();
    }
    /**
     * <code>string draw_type = 20;</code>
     * @return The bytes for drawType.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDrawTypeBytes() {
      return instance.getDrawTypeBytes();
    }
    /**
     * <code>string draw_type = 20;</code>
     * @param value The drawType to set.
     * @return This builder for chaining.
     */
    public Builder setDrawType(
        java.lang.String value) {
      copyOnWrite();
      instance.setDrawType(value);
      return this;
    }
    /**
     * <code>string draw_type = 20;</code>
     * @return This builder for chaining.
     */
    public Builder clearDrawType() {
      copyOnWrite();
      instance.clearDrawType();
      return this;
    }
    /**
     * <code>string draw_type = 20;</code>
     * @param value The bytes for drawType to set.
     * @return This builder for chaining.
     */
    public Builder setDrawTypeBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setDrawTypeBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.DanmuWebPlayerConfig)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "dmSwitch_",
            "aiSwitch_",
            "aiLevel_",
            "blocktop_",
            "blockscroll_",
            "blockbottom_",
            "blockcolor_",
            "blockspecial_",
            "preventshade_",
            "dmask_",
            "opacity_",
            "dmarea_",
            "speedplus_",
            "fontsize_",
            "screensync_",
            "speedsync_",
            "fontfamily_",
            "bold_",
            "fontborder_",
            "drawType_",
          };
          java.lang.String info =
              "\u0000\u0014\u0000\u0000\u0001\u0014\u0014\u0000\u0000\u0000\u0001\u0007\u0002\u0007" +
              "\u0003\u0004\u0004\u0007\u0005\u0007\u0006\u0007\u0007\u0007\b\u0007\t\u0007\n\u0007" +
              "\u000b\u0001\f\u0004\r\u0001\u000e\u0001\u000f\u0007\u0010\u0007\u0011\u0208\u0012" +
              "\u0007\u0013\u0004\u0014\u0208";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig>(
                      DEFAULT_INSTANCE);
              PARSER = parser;
            }
          }
        }
        return parser;
    }
    case GET_MEMOIZED_IS_INITIALIZED: {
      return (byte) 1;
    }
    case SET_MEMOIZED_IS_INITIALIZED: {
      return null;
    }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.DanmuWebPlayerConfig)
  private static final com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig DEFAULT_INSTANCE;
  static {
    DanmuWebPlayerConfig defaultInstance = new DanmuWebPlayerConfig();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      DanmuWebPlayerConfig.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuWebPlayerConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<DanmuWebPlayerConfig> PARSER;

  public static com.google.protobuf.Parser<DanmuWebPlayerConfig> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

