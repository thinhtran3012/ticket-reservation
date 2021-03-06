// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cinema.proto

package io.cinema.proto;

/**
 * Protobuf type {@code GetAvailableSeatsResponse}
 */
public final class GetAvailableSeatsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetAvailableSeatsResponse)
    GetAvailableSeatsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetAvailableSeatsResponse.newBuilder() to construct.
  private GetAvailableSeatsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetAvailableSeatsResponse() {
    seats_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetAvailableSeatsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetAvailableSeatsResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              seats_ = new java.util.ArrayList<io.cinema.proto.Seat>();
              mutable_bitField0_ |= 0x00000001;
            }
            seats_.add(
                input.readMessage(io.cinema.proto.Seat.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        seats_ = java.util.Collections.unmodifiableList(seats_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.cinema.proto.Cinema.internal_static_GetAvailableSeatsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.cinema.proto.Cinema.internal_static_GetAvailableSeatsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.cinema.proto.GetAvailableSeatsResponse.class, io.cinema.proto.GetAvailableSeatsResponse.Builder.class);
  }

  public static final int SEATS_FIELD_NUMBER = 1;
  private java.util.List<io.cinema.proto.Seat> seats_;
  /**
   * <code>repeated .Seat seats = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.cinema.proto.Seat> getSeatsList() {
    return seats_;
  }
  /**
   * <code>repeated .Seat seats = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.cinema.proto.SeatOrBuilder> 
      getSeatsOrBuilderList() {
    return seats_;
  }
  /**
   * <code>repeated .Seat seats = 1;</code>
   */
  @java.lang.Override
  public int getSeatsCount() {
    return seats_.size();
  }
  /**
   * <code>repeated .Seat seats = 1;</code>
   */
  @java.lang.Override
  public io.cinema.proto.Seat getSeats(int index) {
    return seats_.get(index);
  }
  /**
   * <code>repeated .Seat seats = 1;</code>
   */
  @java.lang.Override
  public io.cinema.proto.SeatOrBuilder getSeatsOrBuilder(
      int index) {
    return seats_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < seats_.size(); i++) {
      output.writeMessage(1, seats_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < seats_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, seats_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.cinema.proto.GetAvailableSeatsResponse)) {
      return super.equals(obj);
    }
    io.cinema.proto.GetAvailableSeatsResponse other = (io.cinema.proto.GetAvailableSeatsResponse) obj;

    if (!getSeatsList()
        .equals(other.getSeatsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getSeatsCount() > 0) {
      hash = (37 * hash) + SEATS_FIELD_NUMBER;
      hash = (53 * hash) + getSeatsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.cinema.proto.GetAvailableSeatsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.cinema.proto.GetAvailableSeatsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code GetAvailableSeatsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetAvailableSeatsResponse)
      io.cinema.proto.GetAvailableSeatsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.cinema.proto.Cinema.internal_static_GetAvailableSeatsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.cinema.proto.Cinema.internal_static_GetAvailableSeatsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.cinema.proto.GetAvailableSeatsResponse.class, io.cinema.proto.GetAvailableSeatsResponse.Builder.class);
    }

    // Construct using io.cinema.proto.GetAvailableSeatsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getSeatsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (seatsBuilder_ == null) {
        seats_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        seatsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.cinema.proto.Cinema.internal_static_GetAvailableSeatsResponse_descriptor;
    }

    @java.lang.Override
    public io.cinema.proto.GetAvailableSeatsResponse getDefaultInstanceForType() {
      return io.cinema.proto.GetAvailableSeatsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.cinema.proto.GetAvailableSeatsResponse build() {
      io.cinema.proto.GetAvailableSeatsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.cinema.proto.GetAvailableSeatsResponse buildPartial() {
      io.cinema.proto.GetAvailableSeatsResponse result = new io.cinema.proto.GetAvailableSeatsResponse(this);
      int from_bitField0_ = bitField0_;
      if (seatsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          seats_ = java.util.Collections.unmodifiableList(seats_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.seats_ = seats_;
      } else {
        result.seats_ = seatsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.cinema.proto.GetAvailableSeatsResponse) {
        return mergeFrom((io.cinema.proto.GetAvailableSeatsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.cinema.proto.GetAvailableSeatsResponse other) {
      if (other == io.cinema.proto.GetAvailableSeatsResponse.getDefaultInstance()) return this;
      if (seatsBuilder_ == null) {
        if (!other.seats_.isEmpty()) {
          if (seats_.isEmpty()) {
            seats_ = other.seats_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureSeatsIsMutable();
            seats_.addAll(other.seats_);
          }
          onChanged();
        }
      } else {
        if (!other.seats_.isEmpty()) {
          if (seatsBuilder_.isEmpty()) {
            seatsBuilder_.dispose();
            seatsBuilder_ = null;
            seats_ = other.seats_;
            bitField0_ = (bitField0_ & ~0x00000001);
            seatsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getSeatsFieldBuilder() : null;
          } else {
            seatsBuilder_.addAllMessages(other.seats_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.cinema.proto.GetAvailableSeatsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.cinema.proto.GetAvailableSeatsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<io.cinema.proto.Seat> seats_ =
      java.util.Collections.emptyList();
    private void ensureSeatsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        seats_ = new java.util.ArrayList<io.cinema.proto.Seat>(seats_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.cinema.proto.Seat, io.cinema.proto.Seat.Builder, io.cinema.proto.SeatOrBuilder> seatsBuilder_;

    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public java.util.List<io.cinema.proto.Seat> getSeatsList() {
      if (seatsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(seats_);
      } else {
        return seatsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public int getSeatsCount() {
      if (seatsBuilder_ == null) {
        return seats_.size();
      } else {
        return seatsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public io.cinema.proto.Seat getSeats(int index) {
      if (seatsBuilder_ == null) {
        return seats_.get(index);
      } else {
        return seatsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder setSeats(
        int index, io.cinema.proto.Seat value) {
      if (seatsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSeatsIsMutable();
        seats_.set(index, value);
        onChanged();
      } else {
        seatsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder setSeats(
        int index, io.cinema.proto.Seat.Builder builderForValue) {
      if (seatsBuilder_ == null) {
        ensureSeatsIsMutable();
        seats_.set(index, builderForValue.build());
        onChanged();
      } else {
        seatsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder addSeats(io.cinema.proto.Seat value) {
      if (seatsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSeatsIsMutable();
        seats_.add(value);
        onChanged();
      } else {
        seatsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder addSeats(
        int index, io.cinema.proto.Seat value) {
      if (seatsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSeatsIsMutable();
        seats_.add(index, value);
        onChanged();
      } else {
        seatsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder addSeats(
        io.cinema.proto.Seat.Builder builderForValue) {
      if (seatsBuilder_ == null) {
        ensureSeatsIsMutable();
        seats_.add(builderForValue.build());
        onChanged();
      } else {
        seatsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder addSeats(
        int index, io.cinema.proto.Seat.Builder builderForValue) {
      if (seatsBuilder_ == null) {
        ensureSeatsIsMutable();
        seats_.add(index, builderForValue.build());
        onChanged();
      } else {
        seatsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder addAllSeats(
        java.lang.Iterable<? extends io.cinema.proto.Seat> values) {
      if (seatsBuilder_ == null) {
        ensureSeatsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, seats_);
        onChanged();
      } else {
        seatsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder clearSeats() {
      if (seatsBuilder_ == null) {
        seats_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        seatsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public Builder removeSeats(int index) {
      if (seatsBuilder_ == null) {
        ensureSeatsIsMutable();
        seats_.remove(index);
        onChanged();
      } else {
        seatsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public io.cinema.proto.Seat.Builder getSeatsBuilder(
        int index) {
      return getSeatsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public io.cinema.proto.SeatOrBuilder getSeatsOrBuilder(
        int index) {
      if (seatsBuilder_ == null) {
        return seats_.get(index);  } else {
        return seatsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public java.util.List<? extends io.cinema.proto.SeatOrBuilder> 
         getSeatsOrBuilderList() {
      if (seatsBuilder_ != null) {
        return seatsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(seats_);
      }
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public io.cinema.proto.Seat.Builder addSeatsBuilder() {
      return getSeatsFieldBuilder().addBuilder(
          io.cinema.proto.Seat.getDefaultInstance());
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public io.cinema.proto.Seat.Builder addSeatsBuilder(
        int index) {
      return getSeatsFieldBuilder().addBuilder(
          index, io.cinema.proto.Seat.getDefaultInstance());
    }
    /**
     * <code>repeated .Seat seats = 1;</code>
     */
    public java.util.List<io.cinema.proto.Seat.Builder> 
         getSeatsBuilderList() {
      return getSeatsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.cinema.proto.Seat, io.cinema.proto.Seat.Builder, io.cinema.proto.SeatOrBuilder> 
        getSeatsFieldBuilder() {
      if (seatsBuilder_ == null) {
        seatsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.cinema.proto.Seat, io.cinema.proto.Seat.Builder, io.cinema.proto.SeatOrBuilder>(
                seats_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        seats_ = null;
      }
      return seatsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:GetAvailableSeatsResponse)
  }

  // @@protoc_insertion_point(class_scope:GetAvailableSeatsResponse)
  private static final io.cinema.proto.GetAvailableSeatsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.cinema.proto.GetAvailableSeatsResponse();
  }

  public static io.cinema.proto.GetAvailableSeatsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAvailableSeatsResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetAvailableSeatsResponse>() {
    @java.lang.Override
    public GetAvailableSeatsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetAvailableSeatsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetAvailableSeatsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAvailableSeatsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.cinema.proto.GetAvailableSeatsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

