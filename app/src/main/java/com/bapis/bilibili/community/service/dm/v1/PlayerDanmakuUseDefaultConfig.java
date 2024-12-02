// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * Protobuf type {@code bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig}
 */
public  final class PlayerDanmakuUseDefaultConfig extends
    com.google.protobuf.GeneratedMessageLite<
        PlayerDanmakuUseDefaultConfig, PlayerDanmakuUseDefaultConfig.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig)
    PlayerDanmakuUseDefaultConfigOrBuilder {
  private PlayerDanmakuUseDefaultConfig() {
  }
  public static final int VALUE_FIELD_NUMBER = 1;
  private boolean value_;
  /**
   * <code>bool value = 1;</code>
   * @return The value.
   */
  @java.lang.Override
  public boolean getValue() {
    return value_;
  }
  /**
   * <code>bool value = 1;</code>
   * @param value The value to set.
   */
  private void setValue(boolean value) {
    
    value_ = value;
  }
  /**
   * <code>bool value = 1;</code>
   */
  private void clearValue() {

    value_ = false;
  }

  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * Protobuf type {@code bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig)
      com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfigOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>bool value = 1;</code>
     * @return The value.
     */
    @java.lang.Override
    public boolean getValue() {
      return instance.getValue();
    }
    /**
     * <code>bool value = 1;</code>
     * @param value The value to set.
     * @return This builder for chaining.
     */
    public Builder setValue(boolean value) {
      copyOnWrite();
      instance.setValue(value);
      return this;
    }
    /**
     * <code>bool value = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearValue() {
      copyOnWrite();
      instance.clearValue();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "value_",
          };
          java.lang.String info =
              "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig)
  private static final com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig DEFAULT_INSTANCE;
  static {
    PlayerDanmakuUseDefaultConfig defaultInstance = new PlayerDanmakuUseDefaultConfig();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      PlayerDanmakuUseDefaultConfig.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuUseDefaultConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PlayerDanmakuUseDefaultConfig> PARSER;

  public static com.google.protobuf.Parser<PlayerDanmakuUseDefaultConfig> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

