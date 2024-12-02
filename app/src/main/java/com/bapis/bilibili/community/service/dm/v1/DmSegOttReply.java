// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * <pre>
 * DmSegOttReply .
 * </pre>
 *
 * Protobuf type {@code bilibili.community.service.dm.v1.DmSegOttReply}
 */
public  final class DmSegOttReply extends
    com.google.protobuf.GeneratedMessageLite<
        DmSegOttReply, DmSegOttReply.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.DmSegOttReply)
    DmSegOttReplyOrBuilder {
  private DmSegOttReply() {
    elems_ = emptyProtobufList();
  }
  public static final int ELEMS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.DanmakuElem> elems_;
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmakuElem> getElemsList() {
    return elems_;
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  public java.util.List<? extends com.bapis.bilibili.community.service.dm.v1.DanmakuElemOrBuilder> 
      getElemsOrBuilderList() {
    return elems_;
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  @java.lang.Override
  public int getElemsCount() {
    return elems_.size();
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  @java.lang.Override
  public com.bapis.bilibili.community.service.dm.v1.DanmakuElem getElems(int index) {
    return elems_.get(index);
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  public com.bapis.bilibili.community.service.dm.v1.DanmakuElemOrBuilder getElemsOrBuilder(
      int index) {
    return elems_.get(index);
  }
  private void ensureElemsIsMutable() {
    com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.DanmakuElem> tmp = elems_;
    if (!tmp.isModifiable()) {
      elems_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(tmp);
     }
  }

  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setElems(
      int index, com.bapis.bilibili.community.service.dm.v1.DanmakuElem value) {
    value.getClass();  // minimal bytecode null check
    ensureElemsIsMutable();
    elems_.set(index, value);
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addElems(com.bapis.bilibili.community.service.dm.v1.DanmakuElem value) {
    value.getClass();  // minimal bytecode null check
    ensureElemsIsMutable();
    elems_.add(value);
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addElems(
      int index, com.bapis.bilibili.community.service.dm.v1.DanmakuElem value) {
    value.getClass();  // minimal bytecode null check
    ensureElemsIsMutable();
    elems_.add(index, value);
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  private void addAllElems(
      java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.DanmakuElem> values) {
    ensureElemsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, elems_);
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  private void clearElems() {
    elems_ = emptyProtobufList();
  }
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  private void removeElems(int index) {
    ensureElemsIsMutable();
    elems_.remove(index);
  }

  public static final int STATE_FIELD_NUMBER = 2;
  private int state_;
  /**
   * <pre>
   * state 弹幕区状态  0:打开 1:关闭弹幕区
   * </pre>
   *
   * <code>int32 state = 2;</code>
   * @return The state.
   */
  @java.lang.Override
  public int getState() {
    return state_;
  }
  /**
   * <pre>
   * state 弹幕区状态  0:打开 1:关闭弹幕区
   * </pre>
   *
   * <code>int32 state = 2;</code>
   * @param value The state to set.
   */
  private void setState(int value) {
    
    state_ = value;
  }
  /**
   * <pre>
   * state 弹幕区状态  0:打开 1:关闭弹幕区
   * </pre>
   *
   * <code>int32 state = 2;</code>
   */
  private void clearState() {

    state_ = 0;
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.DmSegOttReply prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * DmSegOttReply .
   * </pre>
   *
   * Protobuf type {@code bilibili.community.service.dm.v1.DmSegOttReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.DmSegOttReply, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.DmSegOttReply)
      com.bapis.bilibili.community.service.dm.v1.DmSegOttReplyOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.DmSegOttReply.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    @java.lang.Override
    public java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmakuElem> getElemsList() {
      return java.util.Collections.unmodifiableList(
          instance.getElemsList());
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    @java.lang.Override
    public int getElemsCount() {
      return instance.getElemsCount();
    }/**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    @java.lang.Override
    public com.bapis.bilibili.community.service.dm.v1.DanmakuElem getElems(int index) {
      return instance.getElems(index);
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder setElems(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuElem value) {
      copyOnWrite();
      instance.setElems(index, value);
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder setElems(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuElem.Builder builderForValue) {
      copyOnWrite();
      instance.setElems(index,
          builderForValue.build());
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder addElems(com.bapis.bilibili.community.service.dm.v1.DanmakuElem value) {
      copyOnWrite();
      instance.addElems(value);
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder addElems(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuElem value) {
      copyOnWrite();
      instance.addElems(index, value);
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder addElems(
        com.bapis.bilibili.community.service.dm.v1.DanmakuElem.Builder builderForValue) {
      copyOnWrite();
      instance.addElems(builderForValue.build());
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder addElems(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuElem.Builder builderForValue) {
      copyOnWrite();
      instance.addElems(index,
          builderForValue.build());
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder addAllElems(
        java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.DanmakuElem> values) {
      copyOnWrite();
      instance.addAllElems(values);
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder clearElems() {
      copyOnWrite();
      instance.clearElems();
      return this;
    }
    /**
     * <pre>
     * elems 弹幕列表
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
     */
    public Builder removeElems(int index) {
      copyOnWrite();
      instance.removeElems(index);
      return this;
    }

    /**
     * <pre>
     * state 弹幕区状态  0:打开 1:关闭弹幕区
     * </pre>
     *
     * <code>int32 state = 2;</code>
     * @return The state.
     */
    @java.lang.Override
    public int getState() {
      return instance.getState();
    }
    /**
     * <pre>
     * state 弹幕区状态  0:打开 1:关闭弹幕区
     * </pre>
     *
     * <code>int32 state = 2;</code>
     * @param value The state to set.
     * @return This builder for chaining.
     */
    public Builder setState(int value) {
      copyOnWrite();
      instance.setState(value);
      return this;
    }
    /**
     * <pre>
     * state 弹幕区状态  0:打开 1:关闭弹幕区
     * </pre>
     *
     * <code>int32 state = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearState() {
      copyOnWrite();
      instance.clearState();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.DmSegOttReply)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.DmSegOttReply();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "elems_",
            com.bapis.bilibili.community.service.dm.v1.DanmakuElem.class,
            "state_",
          };
          java.lang.String info =
              "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004" +
              "";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.DmSegOttReply> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.DmSegOttReply.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.DmSegOttReply>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.DmSegOttReply)
  private static final com.bapis.bilibili.community.service.dm.v1.DmSegOttReply DEFAULT_INSTANCE;
  static {
    DmSegOttReply defaultInstance = new DmSegOttReply();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      DmSegOttReply.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<DmSegOttReply> PARSER;

  public static com.google.protobuf.Parser<DmSegOttReply> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
