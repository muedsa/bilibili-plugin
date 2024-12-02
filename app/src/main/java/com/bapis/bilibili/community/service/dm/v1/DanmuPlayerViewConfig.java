// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * Protobuf type {@code bilibili.community.service.dm.v1.DanmuPlayerViewConfig}
 */
public  final class DanmuPlayerViewConfig extends
    com.google.protobuf.GeneratedMessageLite<
        DanmuPlayerViewConfig, DanmuPlayerViewConfig.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.DanmuPlayerViewConfig)
    DanmuPlayerViewConfigOrBuilder {
  private DanmuPlayerViewConfig() {
    danmukuPlayerDynamicConfig_ = emptyProtobufList();
  }
  private int bitField0_;
  public static final int DANMUKU_DEFAULT_PLAYER_CONFIG_FIELD_NUMBER = 1;
  private com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmukuDefaultPlayerConfig_;
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
   */
  @java.lang.Override
  public boolean hasDanmukuDefaultPlayerConfig() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
   */
  @java.lang.Override
  public com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig getDanmukuDefaultPlayerConfig() {
    return danmukuDefaultPlayerConfig_ == null ? com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig.getDefaultInstance() : danmukuDefaultPlayerConfig_;
  }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setDanmukuDefaultPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig value) {
    value.getClass();  // minimal bytecode null check
    danmukuDefaultPlayerConfig_ = value;
    bitField0_ |= 0x00000001;
    }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
   */
  @java.lang.SuppressWarnings({"ReferenceEquality", "ReturnValueIgnored"})
  private void mergeDanmukuDefaultPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig value) {
    value.getClass();  // minimal bytecode null check
    if (danmukuDefaultPlayerConfig_ != null &&
        danmukuDefaultPlayerConfig_ != com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig.getDefaultInstance()) {
      danmukuDefaultPlayerConfig_ =
        com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig.newBuilder(danmukuDefaultPlayerConfig_).mergeFrom(value).buildPartial();
    } else {
      danmukuDefaultPlayerConfig_ = value;
    }
    bitField0_ |= 0x00000001;
  }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
   */
  private void clearDanmukuDefaultPlayerConfig() {  danmukuDefaultPlayerConfig_ = null;
    bitField0_ = (bitField0_ & ~0x00000001);
  }

  public static final int DANMUKU_PLAYER_CONFIG_FIELD_NUMBER = 2;
  private com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig danmukuPlayerConfig_;
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
   */
  @java.lang.Override
  public boolean hasDanmukuPlayerConfig() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
   */
  @java.lang.Override
  public com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig getDanmukuPlayerConfig() {
    return danmukuPlayerConfig_ == null ? com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig.getDefaultInstance() : danmukuPlayerConfig_;
  }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setDanmukuPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig value) {
    value.getClass();  // minimal bytecode null check
    danmukuPlayerConfig_ = value;
    bitField0_ |= 0x00000002;
    }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
   */
  @java.lang.SuppressWarnings({"ReferenceEquality", "ReturnValueIgnored"})
  private void mergeDanmukuPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig value) {
    value.getClass();  // minimal bytecode null check
    if (danmukuPlayerConfig_ != null &&
        danmukuPlayerConfig_ != com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig.getDefaultInstance()) {
      danmukuPlayerConfig_ =
        com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig.newBuilder(danmukuPlayerConfig_).mergeFrom(value).buildPartial();
    } else {
      danmukuPlayerConfig_ = value;
    }
    bitField0_ |= 0x00000002;
  }
  /**
   * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
   */
  private void clearDanmukuPlayerConfig() {  danmukuPlayerConfig_ = null;
    bitField0_ = (bitField0_ & ~0x00000002);
  }

  public static final int DANMUKU_PLAYER_DYNAMIC_CONFIG_FIELD_NUMBER = 3;
  private com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig> danmukuPlayerDynamicConfig_;
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  @java.lang.Override
  public java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig> getDanmukuPlayerDynamicConfigList() {
    return danmukuPlayerDynamicConfig_;
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  public java.util.List<? extends com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfigOrBuilder> 
      getDanmukuPlayerDynamicConfigOrBuilderList() {
    return danmukuPlayerDynamicConfig_;
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  @java.lang.Override
  public int getDanmukuPlayerDynamicConfigCount() {
    return danmukuPlayerDynamicConfig_.size();
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  @java.lang.Override
  public com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig getDanmukuPlayerDynamicConfig(int index) {
    return danmukuPlayerDynamicConfig_.get(index);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  public com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfigOrBuilder getDanmukuPlayerDynamicConfigOrBuilder(
      int index) {
    return danmukuPlayerDynamicConfig_.get(index);
  }
  private void ensureDanmukuPlayerDynamicConfigIsMutable() {
    com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig> tmp = danmukuPlayerDynamicConfig_;
    if (!tmp.isModifiable()) {
      danmukuPlayerDynamicConfig_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(tmp);
     }
  }

  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setDanmukuPlayerDynamicConfig(
      int index, com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig value) {
    value.getClass();  // minimal bytecode null check
    ensureDanmukuPlayerDynamicConfigIsMutable();
    danmukuPlayerDynamicConfig_.set(index, value);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addDanmukuPlayerDynamicConfig(com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig value) {
    value.getClass();  // minimal bytecode null check
    ensureDanmukuPlayerDynamicConfigIsMutable();
    danmukuPlayerDynamicConfig_.add(value);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addDanmukuPlayerDynamicConfig(
      int index, com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig value) {
    value.getClass();  // minimal bytecode null check
    ensureDanmukuPlayerDynamicConfigIsMutable();
    danmukuPlayerDynamicConfig_.add(index, value);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  private void addAllDanmukuPlayerDynamicConfig(
      java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig> values) {
    ensureDanmukuPlayerDynamicConfigIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, danmukuPlayerDynamicConfig_);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  private void clearDanmukuPlayerDynamicConfig() {
    danmukuPlayerDynamicConfig_ = emptyProtobufList();
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
   */
  private void removeDanmukuPlayerDynamicConfig(int index) {
    ensureDanmukuPlayerDynamicConfigIsMutable();
    danmukuPlayerDynamicConfig_.remove(index);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * Protobuf type {@code bilibili.community.service.dm.v1.DanmuPlayerViewConfig}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.DanmuPlayerViewConfig)
      com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfigOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
     */
    @java.lang.Override
    public boolean hasDanmukuDefaultPlayerConfig() {
      return instance.hasDanmukuDefaultPlayerConfig();
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
     */
    @java.lang.Override
    public com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig getDanmukuDefaultPlayerConfig() {
      return instance.getDanmukuDefaultPlayerConfig();
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
     */
    public Builder setDanmukuDefaultPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig value) {
      copyOnWrite();
      instance.setDanmukuDefaultPlayerConfig(value);
      return this;
      }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
     */
    public Builder setDanmukuDefaultPlayerConfig(
        com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig.Builder builderForValue) {
      copyOnWrite();
      instance.setDanmukuDefaultPlayerConfig(builderForValue.build());
      return this;
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
     */
    public Builder mergeDanmukuDefaultPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig value) {
      copyOnWrite();
      instance.mergeDanmukuDefaultPlayerConfig(value);
      return this;
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuDefaultPlayerConfig danmuku_default_player_config = 1;</code>
     */
    public Builder clearDanmukuDefaultPlayerConfig() {  copyOnWrite();
      instance.clearDanmukuDefaultPlayerConfig();
      return this;
    }

    /**
     * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
     */
    @java.lang.Override
    public boolean hasDanmukuPlayerConfig() {
      return instance.hasDanmukuPlayerConfig();
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
     */
    @java.lang.Override
    public com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig getDanmukuPlayerConfig() {
      return instance.getDanmukuPlayerConfig();
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
     */
    public Builder setDanmukuPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig value) {
      copyOnWrite();
      instance.setDanmukuPlayerConfig(value);
      return this;
      }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
     */
    public Builder setDanmukuPlayerConfig(
        com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig.Builder builderForValue) {
      copyOnWrite();
      instance.setDanmukuPlayerConfig(builderForValue.build());
      return this;
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
     */
    public Builder mergeDanmukuPlayerConfig(com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig value) {
      copyOnWrite();
      instance.mergeDanmukuPlayerConfig(value);
      return this;
    }
    /**
     * <code>.bilibili.community.service.dm.v1.DanmuPlayerConfig danmuku_player_config = 2;</code>
     */
    public Builder clearDanmukuPlayerConfig() {  copyOnWrite();
      instance.clearDanmukuPlayerConfig();
      return this;
    }

    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    @java.lang.Override
    public java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig> getDanmukuPlayerDynamicConfigList() {
      return java.util.Collections.unmodifiableList(
          instance.getDanmukuPlayerDynamicConfigList());
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    @java.lang.Override
    public int getDanmukuPlayerDynamicConfigCount() {
      return instance.getDanmukuPlayerDynamicConfigCount();
    }/**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    @java.lang.Override
    public com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig getDanmukuPlayerDynamicConfig(int index) {
      return instance.getDanmukuPlayerDynamicConfig(index);
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder setDanmukuPlayerDynamicConfig(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig value) {
      copyOnWrite();
      instance.setDanmukuPlayerDynamicConfig(index, value);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder setDanmukuPlayerDynamicConfig(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig.Builder builderForValue) {
      copyOnWrite();
      instance.setDanmukuPlayerDynamicConfig(index,
          builderForValue.build());
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder addDanmukuPlayerDynamicConfig(com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig value) {
      copyOnWrite();
      instance.addDanmukuPlayerDynamicConfig(value);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder addDanmukuPlayerDynamicConfig(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig value) {
      copyOnWrite();
      instance.addDanmukuPlayerDynamicConfig(index, value);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder addDanmukuPlayerDynamicConfig(
        com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig.Builder builderForValue) {
      copyOnWrite();
      instance.addDanmukuPlayerDynamicConfig(builderForValue.build());
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder addDanmukuPlayerDynamicConfig(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig.Builder builderForValue) {
      copyOnWrite();
      instance.addDanmukuPlayerDynamicConfig(index,
          builderForValue.build());
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder addAllDanmukuPlayerDynamicConfig(
        java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig> values) {
      copyOnWrite();
      instance.addAllDanmukuPlayerDynamicConfig(values);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder clearDanmukuPlayerDynamicConfig() {
      copyOnWrite();
      instance.clearDanmukuPlayerDynamicConfig();
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig danmuku_player_dynamic_config = 3;</code>
     */
    public Builder removeDanmukuPlayerDynamicConfig(int index) {
      copyOnWrite();
      instance.removeDanmukuPlayerDynamicConfig(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.DanmuPlayerViewConfig)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "bitField0_",
            "danmukuDefaultPlayerConfig_",
            "danmukuPlayerConfig_",
            "danmukuPlayerDynamicConfig_",
            com.bapis.bilibili.community.service.dm.v1.DanmuPlayerDynamicConfig.class,
          };
          java.lang.String info =
              "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u1009\u0000\u0002" +
              "\u1009\u0001\u0003\u001b";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.DanmuPlayerViewConfig)
  private static final com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig DEFAULT_INSTANCE;
  static {
    DanmuPlayerViewConfig defaultInstance = new DanmuPlayerViewConfig();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      DanmuPlayerViewConfig.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<DanmuPlayerViewConfig> PARSER;

  public static com.google.protobuf.Parser<DanmuPlayerViewConfig> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

