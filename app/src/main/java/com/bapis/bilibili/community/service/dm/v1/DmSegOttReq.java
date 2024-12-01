// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * <pre>
 * DmSegOttReq
 * </pre>
 *
 * Protobuf type {@code bilibili.community.service.dm.v1.DmSegOttReq}
 */
public  final class DmSegOttReq extends
    com.google.protobuf.GeneratedMessageLite<
        DmSegOttReq, DmSegOttReq.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.DmSegOttReq)
    DmSegOttReqOrBuilder {
  private DmSegOttReq() {
  }
  public static final int PID_FIELD_NUMBER = 1;
  private long pid_;
  /**
   * <pre>
   * type=1--&gt; 稿件id  type=2 --&gt; 漫画ID
   * </pre>
   *
   * <code>int64 pid = 1;</code>
   * @return The pid.
   */
  @java.lang.Override
  public long getPid() {
    return pid_;
  }
  /**
   * <pre>
   * type=1--&gt; 稿件id  type=2 --&gt; 漫画ID
   * </pre>
   *
   * <code>int64 pid = 1;</code>
   * @param value The pid to set.
   */
  private void setPid(long value) {
    
    pid_ = value;
  }
  /**
   * <pre>
   * type=1--&gt; 稿件id  type=2 --&gt; 漫画ID
   * </pre>
   *
   * <code>int64 pid = 1;</code>
   */
  private void clearPid() {

    pid_ = 0L;
  }

  public static final int OID_FIELD_NUMBER = 2;
  private long oid_;
  /**
   * <pre>
   * oid 视频id
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   * @return The oid.
   */
  @java.lang.Override
  public long getOid() {
    return oid_;
  }
  /**
   * <pre>
   * oid 视频id
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   * @param value The oid to set.
   */
  private void setOid(long value) {
    
    oid_ = value;
  }
  /**
   * <pre>
   * oid 视频id
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   */
  private void clearOid() {

    oid_ = 0L;
  }

  public static final int TYPE_FIELD_NUMBER = 3;
  private int type_;
  /**
   * <pre>
   * type 1:视频
   * </pre>
   *
   * <code>int32 type = 3;</code>
   * @return The type.
   */
  @java.lang.Override
  public int getType() {
    return type_;
  }
  /**
   * <pre>
   * type 1:视频
   * </pre>
   *
   * <code>int32 type = 3;</code>
   * @param value The type to set.
   */
  private void setType(int value) {
    
    type_ = value;
  }
  /**
   * <pre>
   * type 1:视频
   * </pre>
   *
   * <code>int32 type = 3;</code>
   */
  private void clearType() {

    type_ = 0;
  }

  public static final int SEGMENT_INDEX_FIELD_NUMBER = 4;
  private long segmentIndex_;
  /**
   * <pre>
   * segment_index 分段下标
   * </pre>
   *
   * <code>int64 segment_index = 4;</code>
   * @return The segmentIndex.
   */
  @java.lang.Override
  public long getSegmentIndex() {
    return segmentIndex_;
  }
  /**
   * <pre>
   * segment_index 分段下标
   * </pre>
   *
   * <code>int64 segment_index = 4;</code>
   * @param value The segmentIndex to set.
   */
  private void setSegmentIndex(long value) {
    
    segmentIndex_ = value;
  }
  /**
   * <pre>
   * segment_index 分段下标
   * </pre>
   *
   * <code>int64 segment_index = 4;</code>
   */
  private void clearSegmentIndex() {

    segmentIndex_ = 0L;
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.DmSegOttReq prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * DmSegOttReq
   * </pre>
   *
   * Protobuf type {@code bilibili.community.service.dm.v1.DmSegOttReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.DmSegOttReq, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.DmSegOttReq)
      com.bapis.bilibili.community.service.dm.v1.DmSegOttReqOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.DmSegOttReq.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * type=1--&gt; 稿件id  type=2 --&gt; 漫画ID
     * </pre>
     *
     * <code>int64 pid = 1;</code>
     * @return The pid.
     */
    @java.lang.Override
    public long getPid() {
      return instance.getPid();
    }
    /**
     * <pre>
     * type=1--&gt; 稿件id  type=2 --&gt; 漫画ID
     * </pre>
     *
     * <code>int64 pid = 1;</code>
     * @param value The pid to set.
     * @return This builder for chaining.
     */
    public Builder setPid(long value) {
      copyOnWrite();
      instance.setPid(value);
      return this;
    }
    /**
     * <pre>
     * type=1--&gt; 稿件id  type=2 --&gt; 漫画ID
     * </pre>
     *
     * <code>int64 pid = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPid() {
      copyOnWrite();
      instance.clearPid();
      return this;
    }

    /**
     * <pre>
     * oid 视频id
     * </pre>
     *
     * <code>int64 oid = 2;</code>
     * @return The oid.
     */
    @java.lang.Override
    public long getOid() {
      return instance.getOid();
    }
    /**
     * <pre>
     * oid 视频id
     * </pre>
     *
     * <code>int64 oid = 2;</code>
     * @param value The oid to set.
     * @return This builder for chaining.
     */
    public Builder setOid(long value) {
      copyOnWrite();
      instance.setOid(value);
      return this;
    }
    /**
     * <pre>
     * oid 视频id
     * </pre>
     *
     * <code>int64 oid = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearOid() {
      copyOnWrite();
      instance.clearOid();
      return this;
    }

    /**
     * <pre>
     * type 1:视频
     * </pre>
     *
     * <code>int32 type = 3;</code>
     * @return The type.
     */
    @java.lang.Override
    public int getType() {
      return instance.getType();
    }
    /**
     * <pre>
     * type 1:视频
     * </pre>
     *
     * <code>int32 type = 3;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(int value) {
      copyOnWrite();
      instance.setType(value);
      return this;
    }
    /**
     * <pre>
     * type 1:视频
     * </pre>
     *
     * <code>int32 type = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      copyOnWrite();
      instance.clearType();
      return this;
    }

    /**
     * <pre>
     * segment_index 分段下标
     * </pre>
     *
     * <code>int64 segment_index = 4;</code>
     * @return The segmentIndex.
     */
    @java.lang.Override
    public long getSegmentIndex() {
      return instance.getSegmentIndex();
    }
    /**
     * <pre>
     * segment_index 分段下标
     * </pre>
     *
     * <code>int64 segment_index = 4;</code>
     * @param value The segmentIndex to set.
     * @return This builder for chaining.
     */
    public Builder setSegmentIndex(long value) {
      copyOnWrite();
      instance.setSegmentIndex(value);
      return this;
    }
    /**
     * <pre>
     * segment_index 分段下标
     * </pre>
     *
     * <code>int64 segment_index = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearSegmentIndex() {
      copyOnWrite();
      instance.clearSegmentIndex();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.DmSegOttReq)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.DmSegOttReq();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "pid_",
            "oid_",
            "type_",
            "segmentIndex_",
          };
          java.lang.String info =
              "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002" +
              "\u0003\u0004\u0004\u0002";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.DmSegOttReq> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.DmSegOttReq.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.DmSegOttReq>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.DmSegOttReq)
  private static final com.bapis.bilibili.community.service.dm.v1.DmSegOttReq DEFAULT_INSTANCE;
  static {
    DmSegOttReq defaultInstance = new DmSegOttReq();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      DmSegOttReq.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmSegOttReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<DmSegOttReq> PARSER;

  public static com.google.protobuf.Parser<DmSegOttReq> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

