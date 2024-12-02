// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * <pre>
 * DanmakuAIFlag ai云屏蔽弹幕的配置
 * </pre>
 *
 * Protobuf type {@code bilibili.community.service.dm.v1.DanmakuAIFlag}
 */
public  final class DanmakuAIFlag extends
    com.google.protobuf.GeneratedMessageLite<
        DanmakuAIFlag, DanmakuAIFlag.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.DanmakuAIFlag)
    DanmakuAIFlagOrBuilder {
  private DanmakuAIFlag() {
    dmFlags_ = emptyProtobufList();
  }
  public static final int DM_FLAGS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.DanmakuFlag> dmFlags_;
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmakuFlag> getDmFlagsList() {
    return dmFlags_;
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  public java.util.List<? extends com.bapis.bilibili.community.service.dm.v1.DanmakuFlagOrBuilder> 
      getDmFlagsOrBuilderList() {
    return dmFlags_;
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  @java.lang.Override
  public int getDmFlagsCount() {
    return dmFlags_.size();
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  @java.lang.Override
  public com.bapis.bilibili.community.service.dm.v1.DanmakuFlag getDmFlags(int index) {
    return dmFlags_.get(index);
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  public com.bapis.bilibili.community.service.dm.v1.DanmakuFlagOrBuilder getDmFlagsOrBuilder(
      int index) {
    return dmFlags_.get(index);
  }
  private void ensureDmFlagsIsMutable() {
    com.google.protobuf.Internal.ProtobufList<com.bapis.bilibili.community.service.dm.v1.DanmakuFlag> tmp = dmFlags_;
    if (!tmp.isModifiable()) {
      dmFlags_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(tmp);
     }
  }

  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setDmFlags(
      int index, com.bapis.bilibili.community.service.dm.v1.DanmakuFlag value) {
    value.getClass();  // minimal bytecode null check
    ensureDmFlagsIsMutable();
    dmFlags_.set(index, value);
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addDmFlags(com.bapis.bilibili.community.service.dm.v1.DanmakuFlag value) {
    value.getClass();  // minimal bytecode null check
    ensureDmFlagsIsMutable();
    dmFlags_.add(value);
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void addDmFlags(
      int index, com.bapis.bilibili.community.service.dm.v1.DanmakuFlag value) {
    value.getClass();  // minimal bytecode null check
    ensureDmFlagsIsMutable();
    dmFlags_.add(index, value);
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  private void addAllDmFlags(
      java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.DanmakuFlag> values) {
    ensureDmFlagsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, dmFlags_);
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  private void clearDmFlags() {
    dmFlags_ = emptyProtobufList();
  }
  /**
   * <pre>
   * 云屏蔽等级
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
   */
  private void removeDmFlags(int index) {
    ensureDmFlagsIsMutable();
    dmFlags_.remove(index);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * DanmakuAIFlag ai云屏蔽弹幕的配置
   * </pre>
   *
   * Protobuf type {@code bilibili.community.service.dm.v1.DanmakuAIFlag}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.DanmakuAIFlag)
      com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlagOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    @java.lang.Override
    public java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmakuFlag> getDmFlagsList() {
      return java.util.Collections.unmodifiableList(
          instance.getDmFlagsList());
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    @java.lang.Override
    public int getDmFlagsCount() {
      return instance.getDmFlagsCount();
    }/**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    @java.lang.Override
    public com.bapis.bilibili.community.service.dm.v1.DanmakuFlag getDmFlags(int index) {
      return instance.getDmFlags(index);
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder setDmFlags(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuFlag value) {
      copyOnWrite();
      instance.setDmFlags(index, value);
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder setDmFlags(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuFlag.Builder builderForValue) {
      copyOnWrite();
      instance.setDmFlags(index,
          builderForValue.build());
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder addDmFlags(com.bapis.bilibili.community.service.dm.v1.DanmakuFlag value) {
      copyOnWrite();
      instance.addDmFlags(value);
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder addDmFlags(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuFlag value) {
      copyOnWrite();
      instance.addDmFlags(index, value);
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder addDmFlags(
        com.bapis.bilibili.community.service.dm.v1.DanmakuFlag.Builder builderForValue) {
      copyOnWrite();
      instance.addDmFlags(builderForValue.build());
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder addDmFlags(
        int index, com.bapis.bilibili.community.service.dm.v1.DanmakuFlag.Builder builderForValue) {
      copyOnWrite();
      instance.addDmFlags(index,
          builderForValue.build());
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder addAllDmFlags(
        java.lang.Iterable<? extends com.bapis.bilibili.community.service.dm.v1.DanmakuFlag> values) {
      copyOnWrite();
      instance.addAllDmFlags(values);
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder clearDmFlags() {
      copyOnWrite();
      instance.clearDmFlags();
      return this;
    }
    /**
     * <pre>
     * 云屏蔽等级
     * </pre>
     *
     * <code>repeated .bilibili.community.service.dm.v1.DanmakuFlag dm_flags = 1;</code>
     */
    public Builder removeDmFlags(int index) {
      copyOnWrite();
      instance.removeDmFlags(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.DanmakuAIFlag)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "dmFlags_",
            com.bapis.bilibili.community.service.dm.v1.DanmakuFlag.class,
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
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.DanmakuAIFlag)
  private static final com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag DEFAULT_INSTANCE;
  static {
    DanmakuAIFlag defaultInstance = new DanmakuAIFlag();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      DanmakuAIFlag.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<DanmakuAIFlag> PARSER;

  public static com.google.protobuf.Parser<DanmakuAIFlag> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
