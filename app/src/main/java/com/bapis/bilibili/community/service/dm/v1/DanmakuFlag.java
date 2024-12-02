// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * <pre>
 * --------------------------------------ai------------------------------------------
 * DanmakuFlag ai
 * </pre>
 *
 * Protobuf type {@code bilibili.community.service.dm.v1.DanmakuFlag}
 */
public  final class DanmakuFlag extends
    com.google.protobuf.GeneratedMessageLite<
        DanmakuFlag, DanmakuFlag.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.DanmakuFlag)
    DanmakuFlagOrBuilder {
  private DanmakuFlag() {
  }
  public static final int DMID_FIELD_NUMBER = 1;
  private long dmid_;
  /**
   * <pre>
   * dmid 弹幕id
   * </pre>
   *
   * <code>int64 dmid = 1;</code>
   * @return The dmid.
   */
  @java.lang.Override
  public long getDmid() {
    return dmid_;
  }
  /**
   * <pre>
   * dmid 弹幕id
   * </pre>
   *
   * <code>int64 dmid = 1;</code>
   * @param value The dmid to set.
   */
  private void setDmid(long value) {
    
    dmid_ = value;
  }
  /**
   * <pre>
   * dmid 弹幕id
   * </pre>
   *
   * <code>int64 dmid = 1;</code>
   */
  private void clearDmid() {

    dmid_ = 0L;
  }

  public static final int FLAG_FIELD_NUMBER = 2;
  private int flag_;
  /**
   * <pre>
   * 弹幕分
   * </pre>
   *
   * <code>uint32 flag = 2;</code>
   * @return The flag.
   */
  @java.lang.Override
  public int getFlag() {
    return flag_;
  }
  /**
   * <pre>
   * 弹幕分
   * </pre>
   *
   * <code>uint32 flag = 2;</code>
   * @param value The flag to set.
   */
  private void setFlag(int value) {
    
    flag_ = value;
  }
  /**
   * <pre>
   * 弹幕分
   * </pre>
   *
   * <code>uint32 flag = 2;</code>
   */
  private void clearFlag() {

    flag_ = 0;
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.DanmakuFlag prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * --------------------------------------ai------------------------------------------
   * DanmakuFlag ai
   * </pre>
   *
   * Protobuf type {@code bilibili.community.service.dm.v1.DanmakuFlag}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.DanmakuFlag, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.DanmakuFlag)
      com.bapis.bilibili.community.service.dm.v1.DanmakuFlagOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.DanmakuFlag.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * dmid 弹幕id
     * </pre>
     *
     * <code>int64 dmid = 1;</code>
     * @return The dmid.
     */
    @java.lang.Override
    public long getDmid() {
      return instance.getDmid();
    }
    /**
     * <pre>
     * dmid 弹幕id
     * </pre>
     *
     * <code>int64 dmid = 1;</code>
     * @param value The dmid to set.
     * @return This builder for chaining.
     */
    public Builder setDmid(long value) {
      copyOnWrite();
      instance.setDmid(value);
      return this;
    }
    /**
     * <pre>
     * dmid 弹幕id
     * </pre>
     *
     * <code>int64 dmid = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDmid() {
      copyOnWrite();
      instance.clearDmid();
      return this;
    }

    /**
     * <pre>
     * 弹幕分
     * </pre>
     *
     * <code>uint32 flag = 2;</code>
     * @return The flag.
     */
    @java.lang.Override
    public int getFlag() {
      return instance.getFlag();
    }
    /**
     * <pre>
     * 弹幕分
     * </pre>
     *
     * <code>uint32 flag = 2;</code>
     * @param value The flag to set.
     * @return This builder for chaining.
     */
    public Builder setFlag(int value) {
      copyOnWrite();
      instance.setFlag(value);
      return this;
    }
    /**
     * <pre>
     * 弹幕分
     * </pre>
     *
     * <code>uint32 flag = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFlag() {
      copyOnWrite();
      instance.clearFlag();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.DanmakuFlag)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.DanmakuFlag();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "dmid_",
            "flag_",
          };
          java.lang.String info =
              "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u000b" +
              "";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.DanmakuFlag> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.DanmakuFlag.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.DanmakuFlag>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.DanmakuFlag)
  private static final com.bapis.bilibili.community.service.dm.v1.DanmakuFlag DEFAULT_INSTANCE;
  static {
    DanmakuFlag defaultInstance = new DanmakuFlag();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      DanmakuFlag.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuFlag getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<DanmakuFlag> PARSER;

  public static com.google.protobuf.Parser<DanmakuFlag> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
