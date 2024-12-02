// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * Protobuf type {@code bilibili.community.service.dm.v1.Expressions}
 */
public  final class Expressions extends
    com.google.protobuf.GeneratedMessageLite<
        Expressions, Expressions.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.Expressions)
    ExpressionsOrBuilder {
  private Expressions() {
    data_ = emptyProtobufList();
  }
  public static final int DATA_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.Expression> data_;
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.bapis.bilibili.community.service.dm.v1.Expression> getDataList() {
    return data_;
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  public java.util.List<? extends com.bapis.bilibili.community.service.dm.v1.ExpressionOrBuilder> 
      getDataOrBuilderList() {
    return data_;
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  @java.lang.Override
  public int getDataCount() {
    return data_.size();
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  @java.lang.Override
  public com.bapis.bilibili.community.service.dm.v1.Expression getData(int index) {
    return data_.get(index);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  public com.bapis.bilibili.community.service.dm.v1.ExpressionOrBuilder getDataOrBuilder(
      int index) {
    return data_.get(index);
  }
  private void ensureDataIsMutable() {
    com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.Expression> tmp = data_;
    if (!tmp.isModifiable()) {
      data_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(tmp);
     }
  }

  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setData(
      int index, com.bapis.bilibili.community.service.dm.v1.Expression value) {
    value.getClass();  // minimal bytecode null check
    ensureDataIsMutable();
    data_.set(index, value);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addData(com.bapis.bilibili.community.service.dm.v1.Expression value) {
    value.getClass();  // minimal bytecode null check
    ensureDataIsMutable();
    data_.add(value);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addData(
      int index, com.bapis.bilibili.community.service.dm.v1.Expression value) {
    value.getClass();  // minimal bytecode null check
    ensureDataIsMutable();
    data_.add(index, value);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  private void addAllData(
      java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.Expression> values) {
    ensureDataIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, data_);
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  private void clearData() {
    data_ = emptyProtobufList();
  }
  /**
   * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
   */
  private void removeData(int index) {
    ensureDataIsMutable();
    data_.remove(index);
  }

  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.Expressions parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.Expressions prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * Protobuf type {@code bilibili.community.service.dm.v1.Expressions}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.Expressions, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.Expressions)
      com.bapis.bilibili.community.service.dm.v1.ExpressionsOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.Expressions.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    @java.lang.Override
    public java.util.List<com.bapis.bilibili.community.service.dm.v1.Expression> getDataList() {
      return java.util.Collections.unmodifiableList(
          instance.getDataList());
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    @java.lang.Override
    public int getDataCount() {
      return instance.getDataCount();
    }/**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    @java.lang.Override
    public com.bapis.bilibili.community.service.dm.v1.Expression getData(int index) {
      return instance.getData(index);
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder setData(
        int index, com.bapis.bilibili.community.service.dm.v1.Expression value) {
      copyOnWrite();
      instance.setData(index, value);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder setData(
        int index, com.bapis.bilibili.community.service.dm.v1.Expression.Builder builderForValue) {
      copyOnWrite();
      instance.setData(index,
          builderForValue.build());
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder addData(com.bapis.bilibili.community.service.dm.v1.Expression value) {
      copyOnWrite();
      instance.addData(value);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder addData(
        int index, com.bapis.bilibili.community.service.dm.v1.Expression value) {
      copyOnWrite();
      instance.addData(index, value);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder addData(
        com.bapis.bilibili.community.service.dm.v1.Expression.Builder builderForValue) {
      copyOnWrite();
      instance.addData(builderForValue.build());
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder addData(
        int index, com.bapis.bilibili.community.service.dm.v1.Expression.Builder builderForValue) {
      copyOnWrite();
      instance.addData(index,
          builderForValue.build());
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder addAllData(
        java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.Expression> values) {
      copyOnWrite();
      instance.addAllData(values);
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder clearData() {
      copyOnWrite();
      instance.clearData();
      return this;
    }
    /**
     * <code>repeated .bilibili.community.service.dm.v1.Expression data = 1;</code>
     */
    public Builder removeData(int index) {
      copyOnWrite();
      instance.removeData(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.Expressions)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.Expressions();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "data_",
            com.bapis.bilibili.community.service.dm.v1.Expression.class,
          };
          java.lang.String info =
              "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.Expressions> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.Expressions.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.Expressions>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.Expressions)
  private static final com.bapis.bilibili.community.service.dm.v1.Expressions DEFAULT_INSTANCE;
  static {
    Expressions defaultInstance = new Expressions();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      Expressions.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.Expressions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<Expressions> PARSER;

  public static com.google.protobuf.Parser<Expressions> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

