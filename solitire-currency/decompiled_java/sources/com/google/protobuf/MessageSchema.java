package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* JADX INFO: renamed from: com.google.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i10, int i11, MessageLite messageLite, boolean z10, boolean z11, int[] iArr2, int i12, int i13, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i10;
        this.maxFieldNumber = i11;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z10;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z11;
        this.intArray = iArr2;
        this.checkInitializedCount = i12;
        this.repeatedFieldOffsetStart = i13;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t10, T t11, int i10) {
        return isFieldPresent(t10, i10) == isFieldPresent(t11, i10);
    }

    private static <T> boolean booleanAt(T t10, long j10) {
        return UnsafeUtil.getBoolean(t10, j10);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i10, int i11, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32;
        int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
        int i12 = registers.int1;
        if (i12 < 0 || i12 > i11 - iDecodeVarint322) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i13 = iDecodeVarint322 + i12;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint322 < i13) {
            int i14 = iDecodeVarint322 + 1;
            int i15 = bArr[iDecodeVarint322];
            if (i15 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i15, bArr, i14, registers);
                i15 = registers.int1;
            } else {
                iDecodeVarint32 = i14;
            }
            int i16 = i15 >>> 3;
            int i17 = i15 & 7;
            if (i16 != 1) {
                if (i16 == 2 && i17 == metadata.valueType.getWireType()) {
                    iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i11, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint322 = ArrayDecoders.skipField(i15, bArr, iDecodeVarint32, i11, registers);
                }
            } else if (i17 == metadata.keyType.getWireType()) {
                iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i11, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint322 = ArrayDecoders.skipField(i15, bArr, iDecodeVarint32, i11, registers);
            }
        }
        if (iDecodeVarint322 != i13) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i13;
    }

    private int decodeMapEntryValue(byte[] bArr, int i10, int i11, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i10, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i10));
                return i10 + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i10));
                return i10 + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i10));
                return i10 + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i10));
                return i10 + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i10, i11, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i10, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t10, long j10) {
        return UnsafeUtil.getDouble(t10, j10);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i10, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i10);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i10)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i10)) == null) ? ub : (UB) filterUnknownEnumMap(i10, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i10, int i11, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i11, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t10, long j10) {
        return UnsafeUtil.getFloat(t10, j10);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i10) {
        return (Internal.EnumVerifier) this.objects[((i10 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i10) {
        return this.objects[(i10 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i10) {
        int i11 = (i10 / 3) * 2;
        Schema schema = (Schema) this.objects[i11];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i11 + 1]);
        this.objects[i11] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t10) {
        int i10;
        int i11;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeSFixed32Size;
        boolean z10;
        int iComputeSizeFixed32List;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i12 = 1048575;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i14);
            int iNumberAt = numberAt(i14);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i10 = this.buffer[i14 + 2];
                int i17 = i10 & i12;
                i11 = 1 << (i10 >>> 20);
                if (i17 != i13) {
                    i16 = unsafe.getInt(t10, i17);
                    i13 = i17;
                }
            } else {
                i10 = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i14 + 2] & i12;
                i11 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i16 & i11) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if ((i16 & i11) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if ((i16 & i11) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t10, jOffset));
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if ((i16 & i11) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t10, jOffset));
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if ((i16 & i11) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t10, jOffset));
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if ((i16 & i11) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if ((i16 & i11) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i16 & i11) != 0) {
                        Object object = unsafe.getObject(t10, jOffset);
                        iComputeBoolSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 9:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t10, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 10:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i16 & i11) != 0) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i16 & i11) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t10, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeBoolSize;
                    break;
                case 19:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 20:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 21:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 22:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 23:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 24:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 25:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeBoolSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t10, jOffset));
                    i15 += iComputeBoolSize;
                    break;
                case 27:
                    iComputeBoolSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t10, jOffset), getMessageFieldSchema(i14));
                    i15 += iComputeBoolSize;
                    break;
                case 28:
                    iComputeBoolSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t10, jOffset));
                    i15 += iComputeBoolSize;
                    break;
                case 29:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeBoolSize;
                    break;
                case 30:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 31:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 32:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 33:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 34:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t10, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 49:
                    iComputeBoolSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t10, jOffset), getMessageFieldSchema(i14));
                    i15 += iComputeBoolSize;
                    break;
                case 50:
                    iComputeBoolSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t10, jOffset), getMapFieldDefaultEntry(i14));
                    i15 += iComputeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        Object object2 = unsafe.getObject(t10, jOffset);
                        iComputeBoolSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t10, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t10, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t10, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t10, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeBoolSize;
                    }
                    break;
            }
            i14 += 3;
            i12 = 1048575;
        }
        int unknownFieldsSerializedSize = i15 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t10);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t10).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t10) {
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i10 = 0;
        for (int i11 = 0; i11 < this.buffer.length; i11 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i11);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i11);
            long jOffset = offset(iTypeAndOffsetAt);
            int i12 = (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i11 + 2] & 1048575;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t10, i11)) {
                        Object object = UnsafeUtil.getObject(t10, jOffset);
                        iComputeDoubleSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t10, jOffset), getMessageFieldSchema(i11));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t10, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t10, jOffset), getMessageFieldSchema(i11));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t10, jOffset));
                    i10 += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t10, jOffset), getMessageFieldSchema(i11));
                    i10 += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t10, jOffset));
                    i10 += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t10, jOffset), false);
                    i10 += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t10, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t10, i12, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t10, jOffset), getMessageFieldSchema(i11));
                    i10 += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t10, jOffset), getMapFieldDefaultEntry(i11));
                    i10 += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        Object object2 = UnsafeUtil.getObject(t10, jOffset);
                        iComputeDoubleSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t10, jOffset), getMessageFieldSchema(i11));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t10, jOffset));
                        i10 += iComputeDoubleSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t10, iNumberAt, i11)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t10, jOffset), getMessageFieldSchema(i11));
                        i10 += iComputeDoubleSize;
                    }
                    break;
            }
        }
        return i10 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t10);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t10) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t10));
    }

    private static <T> int intAt(T t10, long j10) {
        return UnsafeUtil.getInt(t10, j10);
    }

    private static boolean isEnforceUtf8(int i10) {
        return (i10 & 536870912) != 0;
    }

    private boolean isFieldPresent(T t10, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? isFieldPresent(t10, i10) : (i12 & i13) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i10, int i11) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i10));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!messageFieldSchema.isInitialized(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.Schema] */
    private boolean isMapInitialized(T t10, int i10, int i11) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t10, offset(i10)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t10, T t11, int i10) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i10) & 1048575;
        return UnsafeUtil.getInt(t10, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t11, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t10, int i10, int i11) {
        return UnsafeUtil.getInt(t10, (long) (presenceMaskAndOffsetAt(i11) & 1048575)) == i10;
    }

    private static boolean isRequired(int i10) {
        return (i10 & 268435456) != 0;
    }

    private static List<?> listAt(Object obj, long j10) {
        return (List) UnsafeUtil.getObject(obj, j10);
    }

    private static <T> long longAt(T t10, long j10) {
        return UnsafeUtil.getLong(t10, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:247:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
    
        r0 = r18.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
    
        if (r0 >= r18.repeatedFieldOffsetStart) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        r4 = filterMapUnknownEnumValues(r21, r18.intArray[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
    
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ab, code lost:
    
        if (r4 == null) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
    
        r7.setBuilderToMessage(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0649 A[Catch: all -> 0x06a1, TRY_LEAVE, TryCatch #0 {all -> 0x06a1, blocks: (B:158:0x061a, B:169:0x0643, B:171:0x0649, B:181:0x0671, B:182:0x0676), top: B:210:0x061a }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x06b3 A[LOOP:2: B:201:0x06af->B:203:0x06b3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x06c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r19, com.google.protobuf.ExtensionSchema<ET> r20, T r21, com.google.protobuf.Reader r22, com.google.protobuf.ExtensionRegistryLite r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i10, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(i10));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t10, T t11, int i10) {
        if (isFieldPresent(t11, i10)) {
            long jOffset = offset(typeAndOffsetAt(i10));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t11, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i10) + " is present but null: " + t11);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i10);
            if (!isFieldPresent(t10, i10)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t10, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t10, jOffset, object);
                }
                setFieldPresent(t10, i10);
                return;
            }
            Object object2 = unsafe.getObject(t10, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t10, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t10, T t11, int i10) {
        int iNumberAt = numberAt(i10);
        if (isOneofPresent(t11, iNumberAt, i10)) {
            long jOffset = offset(typeAndOffsetAt(i10));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t11, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i10) + " is present but null: " + t11);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i10);
            if (!isOneofPresent(t10, iNumberAt, i10)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t10, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t10, jOffset, object);
                }
                setOneofPresent(t10, iNumberAt, i10);
                return;
            }
            Object object2 = unsafe.getObject(t10, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t10, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t10, T t11, int i10) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i10);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i10);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putDouble(t10, jOffset, UnsafeUtil.getDouble(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 1:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putFloat(t10, jOffset, UnsafeUtil.getFloat(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 2:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 3:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 4:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 5:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 6:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 7:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putBoolean(t10, jOffset, UnsafeUtil.getBoolean(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 8:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 9:
                mergeMessage(t10, t11, i10);
                break;
            case 10:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 11:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 12:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 13:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 14:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 15:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 16:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                }
                break;
            case 17:
                mergeMessage(t10, t11, i10);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t10, t11, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t10, t11, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t11, iNumberAt, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setOneofPresent(t10, iNumberAt, i10);
                }
                break;
            case 60:
                mergeOneofMessage(t10, t11, i10);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t11, iNumberAt, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setOneofPresent(t10, iNumberAt, i10);
                }
                break;
            case 68:
                mergeOneofMessage(t10, t11, i10);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t10, int i10) {
        Schema messageFieldSchema = getMessageFieldSchema(i10);
        long jOffset = offset(typeAndOffsetAt(i10));
        if (!isFieldPresent(t10, i10)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t10, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t10, int i10, int i11) {
        Schema messageFieldSchema = getMessageFieldSchema(i11);
        if (!isOneofPresent(t10, i10, i11)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t10, offset(typeAndOffsetAt(i11)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i10;
        boolean z10 = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i11 = 0;
        int i12 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i11++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i12++;
            }
        }
        int[] iArr2 = i11 > 0 ? new int[i11] : null;
        int[] iArr3 = i12 > 0 ? new int[i12] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i13 < fields.length) {
            FieldInfo fieldInfo2 = fields[i13];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i14, objArr);
            if (i15 < checkInitialized.length && checkInitialized[i15] == fieldNumber3) {
                checkInitialized[i15] = i14;
                i15++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i16] = i14;
                i16++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    i10 = i14;
                    iArr3[i17] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i17++;
                }
                i13++;
                i14 = i10 + 3;
            }
            i10 = i14;
            i13++;
            i14 = i10 + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z10, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo r34, com.google.protobuf.NewInstanceSchema r35, com.google.protobuf.ListFieldSchema r36, com.google.protobuf.UnknownFieldSchema<?, ?> r37, com.google.protobuf.ExtensionSchema<?> r38, com.google.protobuf.MapFieldSchema r39) {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    private int numberAt(int i10) {
        return this.buffer[i10];
    }

    private static long offset(int i10) {
        return i10 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t10, long j10) {
        return ((Boolean) UnsafeUtil.getObject(t10, j10)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t10, long j10) {
        return ((Double) UnsafeUtil.getObject(t10, j10)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t10, long j10) {
        return ((Float) UnsafeUtil.getObject(t10, j10)).floatValue();
    }

    private static <T> int oneofIntAt(T t10, long j10) {
        return ((Integer) UnsafeUtil.getObject(t10, j10)).intValue();
    }

    private static <T> long oneofLongAt(T t10, long j10) {
        return ((Long) UnsafeUtil.getObject(t10, j10)).longValue();
    }

    private <K, V> int parseMapField(T t10, byte[] bArr, int i10, int i11, int i12, long j10, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i12);
        Object object = unsafe.getObject(t10, j10);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t10, j10, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i10, i11, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j11 = this.buffer[i17 + 2] & 1048575;
        switch (i16) {
            case 51:
                if (i14 != 1) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i10)));
                int i18 = i10 + 8;
                unsafe.putInt(t10, j11, i13);
                return i18;
            case 52:
                if (i14 != 5) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i10)));
                int i19 = i10 + 4;
                unsafe.putInt(t10, j11, i13);
                return i19;
            case 53:
            case 54:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                unsafe.putObject(t10, j10, Long.valueOf(registers.long1));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                unsafe.putObject(t10, j10, Integer.valueOf(registers.int1));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i14 != 1) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i10)));
                int i20 = i10 + 8;
                unsafe.putInt(t10, j11, i13);
                return i20;
            case 57:
            case 64:
                if (i14 != 5) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i10)));
                int i21 = i10 + 4;
                unsafe.putInt(t10, j11, i13);
                return i21;
            case 58:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                unsafe.putObject(t10, j10, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint642;
            case 59:
                if (i14 != 2) {
                    return i10;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                int i22 = registers.int1;
                if (i22 == 0) {
                    unsafe.putObject(t10, j10, "");
                } else {
                    if ((i15 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i22)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t10, j10, new String(bArr, iDecodeVarint322, i22, Internal.UTF_8));
                    iDecodeVarint322 += i22;
                }
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint322;
            case 60:
                if (i14 != 2) {
                    return i10;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t10, i13, i17);
                int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i17), bArr, i10, i11, registers);
                storeOneofMessageField(t10, i13, i17, objMutableOneofMessageFieldForMerge);
                return iMergeMessageField;
            case 61:
                if (i14 != 2) {
                    return i10;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i10, registers);
                unsafe.putObject(t10, j10, registers.object1);
                unsafe.putInt(t10, j11, i13);
                return iDecodeBytes;
            case 63:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                int i23 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i17);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i23)) {
                    unsafe.putObject(t10, j10, Integer.valueOf(i23));
                    unsafe.putInt(t10, j11, i13);
                } else {
                    getMutableUnknownFields(t10).storeField(i12, Long.valueOf(i23));
                }
                return iDecodeVarint323;
            case 66:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                unsafe.putObject(t10, j10, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint324;
            case 67:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                unsafe.putObject(t10, j10, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint643;
            case 68:
                if (i14 != 3) {
                    return i10;
                }
                Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t10, i13, i17);
                int iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i17), bArr, i10, i11, (i12 & (-8)) | 4, registers);
                storeOneofMessageField(t10, i13, i17, objMutableOneofMessageFieldForMerge2);
                return iMergeGroupField;
            default:
                return i10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02e1, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0304, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0307, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x029c, code lost:
    
        if (r0 != r10) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x029e, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r1 = r18;
        r2 = r19;
        r7 = r22;
        r6 = r26;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0088. Please report as an issue. */
    @com.google.protobuf.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseProto3Message(T r30, byte[] r31, int r32, int r33, com.google.protobuf.ArrayDecoders.Registers r34) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    private int parseRepeatedField(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t10, j11);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t10, j11, protobufListMutableCopyWithCapacity2);
        }
        switch (i16) {
            case 18:
            case 35:
                return i14 == 2 ? ArrayDecoders.decodePackedDoubleList(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 1 ? ArrayDecoders.decodeDoubleList(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 19:
            case 36:
                return i14 == 2 ? ArrayDecoders.decodePackedFloatList(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 5 ? ArrayDecoders.decodeFloatList(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 20:
            case 21:
            case 37:
            case 38:
                return i14 == 2 ? ArrayDecoders.decodePackedVarint64List(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 0 ? ArrayDecoders.decodeVarint64List(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 22:
            case 29:
            case 39:
            case 43:
                return i14 == 2 ? ArrayDecoders.decodePackedVarint32List(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 0 ? ArrayDecoders.decodeVarint32List(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 23:
            case 32:
            case 40:
            case 46:
                return i14 == 2 ? ArrayDecoders.decodePackedFixed64List(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 1 ? ArrayDecoders.decodeFixed64List(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 24:
            case 31:
            case 41:
            case 45:
                return i14 == 2 ? ArrayDecoders.decodePackedFixed32List(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 5 ? ArrayDecoders.decodeFixed32List(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 25:
            case 42:
                return i14 == 2 ? ArrayDecoders.decodePackedBoolList(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 0 ? ArrayDecoders.decodeBoolList(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 26:
                return i14 == 2 ? (j10 & 536870912) == 0 ? ArrayDecoders.decodeStringList(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : ArrayDecoders.decodeStringListRequireUtf8(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 27:
                return i14 == 2 ? ArrayDecoders.decodeMessageList(getMessageFieldSchema(i15), i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 28:
                return i14 == 2 ? ArrayDecoders.decodeBytesList(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 30:
            case 44:
                if (i14 == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i10, protobufListMutableCopyWithCapacity2, registers);
                } else {
                    if (i14 != 0) {
                        return i10;
                    }
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) t10, i13, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(i15), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                return i14 == 2 ? ArrayDecoders.decodePackedSInt32List(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 0 ? ArrayDecoders.decodeSInt32List(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 34:
            case 48:
                return i14 == 2 ? ArrayDecoders.decodePackedSInt64List(bArr, i10, protobufListMutableCopyWithCapacity2, registers) : i14 == 0 ? ArrayDecoders.decodeSInt64List(i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            case 49:
                return i14 == 3 ? ArrayDecoders.decodeGroupList(getMessageFieldSchema(i15), i12, bArr, i10, i11, protobufListMutableCopyWithCapacity2, registers) : i10;
            default:
                return i10;
        }
    }

    private int positionForFieldNumber(int i10) {
        if (i10 < this.minFieldNumber || i10 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i10, 0);
    }

    private int presenceMaskAndOffsetAt(int i10) {
        return this.buffer[i10 + 2];
    }

    private <E> void readGroupList(Object obj, long j10, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j10), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i10, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i10)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i10, Reader reader) throws IOException {
        if (isEnforceUtf8(i10)) {
            UnsafeUtil.putObject(obj, offset(i10), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i10), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i10), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i10, Reader reader) throws IOException {
        if (isEnforceUtf8(i10)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i10)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i10)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t10, int i10) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i10);
        long j10 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j10 == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t10, j10, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t10, j10));
    }

    private void setOneofPresent(T t10, int i10, int i11) {
        UnsafeUtil.putInt(t10, presenceMaskAndOffsetAt(i11) & 1048575, i10);
    }

    private int slowPositionForFieldNumber(int i10, int i11) {
        int length = (this.buffer.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int iNumberAt = numberAt(i13);
            if (i10 == iNumberAt) {
                return i13;
            }
            if (i10 < iNumberAt) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(com.google.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.storeFieldData(com.google.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(T t10, int i10, Object obj) {
        UNSAFE.putObject(t10, offset(typeAndOffsetAt(i10)), obj);
        setFieldPresent(t10, i10);
    }

    private void storeOneofMessageField(T t10, int i10, int i11, Object obj) {
        UNSAFE.putObject(t10, offset(typeAndOffsetAt(i11)), obj);
        setOneofPresent(t10, i10, i11);
    }

    private static int type(int i10) {
        return (i10 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i10) {
        return this.buffer[i10 + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto2(T r18, com.google.protobuf.Writer r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto3(T r13, com.google.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            writer.writeMap(i10, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i10, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i10, (String) obj);
        } else {
            writer.writeBytes(i10, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t10, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t10), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t10, T t11) {
        int length = this.buffer.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!equals(t10, t11, i10)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t10).equals(this.unknownFieldSchema.getFromMessage(t11))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t10).equals(this.extensionSchema.getExtensions(t11));
        }
        return true;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t10) {
        return this.proto3 ? getSerializedSizeProto3(t10) : getSerializedSizeProto2(t10);
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t10) {
        int i10;
        int iHashLong;
        int length = this.buffer.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i12);
            int iNumberAt = numberAt(i12);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t10, jOffset)));
                    i11 = i10 + iHashLong;
                    break;
                case 1:
                    i10 = i11 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 2:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 3:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 4:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 5:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 6:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 7:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 8:
                    i10 = i11 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t10, jOffset)).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t10, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 11:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 12:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 13:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 14:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 15:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 16:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t10, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 50:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t10, jOffset)));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t10, jOffset)).hashCode();
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                        i11 = i10 + iHashLong;
                    }
                    break;
            }
        }
        int iHashCode2 = (i11 * 53) + this.unknownFieldSchema.getFromMessage(t10).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t10).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized(T r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r0 = r8
            r1 = r9
            r10 = r1
        Lb:
            int r2 = r6.checkInitializedCount
            r3 = 1
            if (r10 >= r2) goto Lb1
            int[] r2 = r6.intArray
            r11 = r2[r10]
            int r12 = r6.numberAt(r11)
            int r13 = r6.typeAndOffsetAt(r11)
            int[] r2 = r6.buffer
            int r4 = r11 + 2
            r2 = r2[r4]
            r4 = r2 & r8
            int r2 = r2 >>> 20
            int r14 = r3 << r2
            if (r4 == r0) goto L37
            if (r4 == r8) goto L33
            sun.misc.Unsafe r0 = com.google.protobuf.MessageSchema.UNSAFE
            long r1 = (long) r4
            int r1 = r0.getInt(r7, r1)
        L33:
            r16 = r1
            r15 = r4
            goto L3a
        L37:
            r15 = r0
            r16 = r1
        L3a:
            boolean r0 = isRequired(r13)
            if (r0 == 0) goto L50
            r0 = r17
            r1 = r18
            r2 = r11
            r3 = r15
            r4 = r16
            r5 = r14
            boolean r0 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L50
            return r9
        L50:
            int r0 = type(r13)
            r1 = 9
            if (r0 == r1) goto L90
            r1 = 17
            if (r0 == r1) goto L90
            r1 = 27
            if (r0 == r1) goto L89
            r1 = 60
            if (r0 == r1) goto L78
            r1 = 68
            if (r0 == r1) goto L78
            r1 = 49
            if (r0 == r1) goto L89
            r1 = 50
            if (r0 == r1) goto L71
            goto Laa
        L71:
            boolean r0 = r6.isMapInitialized(r7, r13, r11)
            if (r0 != 0) goto Laa
            return r9
        L78:
            boolean r0 = r6.isOneofPresent(r7, r12, r11)
            if (r0 == 0) goto Laa
            com.google.protobuf.Schema r0 = r6.getMessageFieldSchema(r11)
            boolean r0 = isInitialized(r7, r13, r0)
            if (r0 != 0) goto Laa
            return r9
        L89:
            boolean r0 = r6.isListInitialized(r7, r13, r11)
            if (r0 != 0) goto Laa
            return r9
        L90:
            r0 = r17
            r1 = r18
            r2 = r11
            r3 = r15
            r4 = r16
            r5 = r14
            boolean r0 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r0 == 0) goto Laa
            com.google.protobuf.Schema r0 = r6.getMessageFieldSchema(r11)
            boolean r0 = isInitialized(r7, r13, r0)
            if (r0 != 0) goto Laa
            return r9
        Laa:
            int r10 = r10 + 1
            r0 = r15
            r1 = r16
            goto Lb
        Lb1:
            boolean r0 = r6.hasExtensions
            if (r0 == 0) goto Lc2
            com.google.protobuf.ExtensionSchema<?> r0 = r6.extensionSchema
            com.google.protobuf.FieldSet r0 = r0.getExtensions(r7)
            boolean r0 = r0.isInitialized()
            if (r0 != 0) goto Lc2
            return r9
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.isInitialized(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void makeImmutable(T r8) {
        /*
            r7 = this;
            boolean r0 = isMutable(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.protobuf.GeneratedMessageLite
            if (r0 == 0) goto L17
            r0 = r8
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            r0.clearMemoizedSerializedSize()
            r0.clearMemoizedHashCode()
            r0.markImmutable()
        L17:
            int[] r0 = r7.buffer
            int r0 = r0.length
            r1 = 0
        L1b:
            if (r1 >= r0) goto L5f
            int r2 = r7.typeAndOffsetAt(r1)
            long r3 = offset(r2)
            int r2 = type(r2)
            r5 = 9
            if (r2 == r5) goto L49
            switch(r2) {
                case 17: goto L49;
                case 18: goto L43;
                case 19: goto L43;
                case 20: goto L43;
                case 21: goto L43;
                case 22: goto L43;
                case 23: goto L43;
                case 24: goto L43;
                case 25: goto L43;
                case 26: goto L43;
                case 27: goto L43;
                case 28: goto L43;
                case 29: goto L43;
                case 30: goto L43;
                case 31: goto L43;
                case 32: goto L43;
                case 33: goto L43;
                case 34: goto L43;
                case 35: goto L43;
                case 36: goto L43;
                case 37: goto L43;
                case 38: goto L43;
                case 39: goto L43;
                case 40: goto L43;
                case 41: goto L43;
                case 42: goto L43;
                case 43: goto L43;
                case 44: goto L43;
                case 45: goto L43;
                case 46: goto L43;
                case 47: goto L43;
                case 48: goto L43;
                case 49: goto L43;
                case 50: goto L31;
                default: goto L30;
            }
        L30:
            goto L5c
        L31:
            sun.misc.Unsafe r2 = com.google.protobuf.MessageSchema.UNSAFE
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L5c
            com.google.protobuf.MapFieldSchema r6 = r7.mapFieldSchema
            java.lang.Object r5 = r6.toImmutable(r5)
            r2.putObject(r8, r3, r5)
            goto L5c
        L43:
            com.google.protobuf.ListFieldSchema r2 = r7.listFieldSchema
            r2.makeImmutableListAt(r8, r3)
            goto L5c
        L49:
            boolean r2 = r7.isFieldPresent(r8, r1)
            if (r2 == 0) goto L5c
            com.google.protobuf.Schema r2 = r7.getMessageFieldSchema(r1)
            sun.misc.Unsafe r5 = com.google.protobuf.MessageSchema.UNSAFE
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.makeImmutable(r3)
        L5c:
            int r1 = r1 + 3
            goto L1b
        L5f:
            com.google.protobuf.UnknownFieldSchema<?, ?> r0 = r7.unknownFieldSchema
            r0.makeImmutable(r8)
            boolean r0 = r7.hasExtensions
            if (r0 == 0) goto L6d
            com.google.protobuf.ExtensionSchema<?> r0 = r7.extensionSchema
            r0.makeImmutable(r8)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.makeImmutable(java.lang.Object):void");
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t10, T t11) {
        checkMutable(t10);
        t11.getClass();
        for (int i10 = 0; i10 < this.buffer.length; i10 += 3) {
            mergeSingleField(t10, t11, i10);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t10, t11);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t10, t11);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x008f. Please report as an issue. */
    @CanIgnoreReturnValue
    int parseProto2Message(T t10, byte[] bArr, int i10, int i11, int i12, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i13;
        MessageSchema<T> messageSchema;
        int i14;
        int i15;
        int i16;
        int i17;
        T t11;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        byte[] bArr2;
        int iDecodeVarint64;
        int i29;
        int i30;
        MessageSchema<T> messageSchema2 = this;
        T t12 = t10;
        byte[] bArr3 = bArr;
        int i31 = i11;
        int i32 = i12;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(t10);
        Unsafe unsafe2 = UNSAFE;
        int iDecodeUnknownField = i10;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = -1;
        int i37 = 1048575;
        while (true) {
            if (iDecodeUnknownField < i31) {
                int i38 = iDecodeUnknownField + 1;
                byte b10 = bArr3[iDecodeUnknownField];
                if (b10 < 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(b10, bArr3, i38, registers2);
                    i18 = registers2.int1;
                    i38 = iDecodeVarint32;
                } else {
                    i18 = b10;
                }
                int i39 = i18 >>> 3;
                int i40 = i18 & 7;
                int iPositionForFieldNumber = i39 > i36 ? messageSchema2.positionForFieldNumber(i39, i33 / 3) : messageSchema2.positionForFieldNumber(i39);
                if (iPositionForFieldNumber == -1) {
                    i19 = i39;
                    i20 = i38;
                    i15 = i18;
                    i21 = i35;
                    i22 = i37;
                    unsafe = unsafe2;
                    i13 = i32;
                    i23 = 0;
                } else {
                    int i41 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i41);
                    long jOffset = offset(i41);
                    int i42 = i18;
                    if (iType <= 17) {
                        int i43 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i44 = 1 << (i43 >>> 20);
                        int i45 = i43 & 1048575;
                        if (i45 != i37) {
                            if (i37 != 1048575) {
                                unsafe2.putInt(t12, i37, i35);
                            }
                            i25 = i45;
                            i24 = unsafe2.getInt(t12, i45);
                        } else {
                            i24 = i35;
                            i25 = i37;
                        }
                        switch (iType) {
                            case 0:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 1) {
                                    UnsafeUtil.putDouble(t12, jOffset, ArrayDecoders.decodeDouble(bArr2, i38));
                                    iDecodeUnknownField = i38 + 8;
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 1:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 5) {
                                    UnsafeUtil.putFloat(t12, jOffset, ArrayDecoders.decodeFloat(bArr2, i38));
                                    iDecodeUnknownField = i38 + 4;
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i38, registers2);
                                    unsafe2.putLong(t10, jOffset, registers2.long1);
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i38, registers2);
                                    unsafe2.putInt(t12, jOffset, registers2.int1);
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 1) {
                                    unsafe2.putLong(t10, jOffset, ArrayDecoders.decodeFixed64(bArr2, i38));
                                    iDecodeUnknownField = i38 + 8;
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 5) {
                                    unsafe2.putInt(t12, jOffset, ArrayDecoders.decodeFixed32(bArr2, i38));
                                    iDecodeUnknownField = i38 + 4;
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 7:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i38, registers2);
                                    UnsafeUtil.putBoolean(t12, jOffset, registers2.long1 != 0);
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 8:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 2) {
                                    iDecodeUnknownField = (536870912 & i41) == 0 ? ArrayDecoders.decodeString(bArr2, i38, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i38, registers2);
                                    unsafe2.putObject(t12, jOffset, registers2.object1);
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 2) {
                                    Object objMutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t12, i28);
                                    iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i28), bArr, i38, i11, registers);
                                    messageSchema2.storeMessageField(t12, i28, objMutableMessageFieldForMerge);
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 10:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 2) {
                                    iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i38, registers2);
                                    unsafe2.putObject(t12, jOffset, registers2.object1);
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 12:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i38, registers2);
                                    int i46 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i28);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i46)) {
                                        unsafe2.putInt(t12, jOffset, i46);
                                        i35 = i24 | i44;
                                        i32 = i12;
                                        i33 = i28;
                                        i34 = i27;
                                        i36 = i19;
                                        i37 = i26;
                                        bArr3 = bArr2;
                                    } else {
                                        getMutableUnknownFields(t10).storeField(i27, Long.valueOf(i46));
                                        i33 = i28;
                                        i35 = i24;
                                        i34 = i27;
                                        i36 = i19;
                                        i37 = i26;
                                        i32 = i12;
                                        bArr3 = bArr2;
                                    }
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                if (i40 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i38, registers2);
                                    unsafe2.putInt(t12, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 16:
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                bArr2 = bArr;
                                if (i40 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i38, registers2);
                                    unsafe2.putLong(t10, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i35 = i24 | i44;
                                    i32 = i12;
                                    i33 = i28;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i34 = i27;
                                    i36 = i19;
                                    i37 = i26;
                                    bArr3 = bArr2;
                                } else {
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            case 17:
                                if (i40 == 3) {
                                    Object objMutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t12, iPositionForFieldNumber);
                                    iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i38, i11, (i39 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t12, iPositionForFieldNumber, objMutableMessageFieldForMerge2);
                                    i35 = i24 | i44;
                                    i37 = i25;
                                    i32 = i12;
                                    i33 = iPositionForFieldNumber;
                                    i34 = i42;
                                    i36 = i39;
                                    bArr3 = bArr;
                                } else {
                                    i19 = i39;
                                    i26 = i25;
                                    i27 = i42;
                                    i28 = iPositionForFieldNumber;
                                    i22 = i26;
                                    i13 = i12;
                                    i20 = i38;
                                    i23 = i28;
                                    unsafe = unsafe2;
                                    i21 = i24;
                                    i15 = i27;
                                }
                                break;
                            default:
                                i19 = i39;
                                i28 = iPositionForFieldNumber;
                                i26 = i25;
                                i27 = i42;
                                i22 = i26;
                                i13 = i12;
                                i20 = i38;
                                i23 = i28;
                                unsafe = unsafe2;
                                i21 = i24;
                                i15 = i27;
                                break;
                        }
                    } else {
                        i19 = i39;
                        i22 = i37;
                        i21 = i35;
                        if (iType == 27) {
                            if (i40 == 2) {
                                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t12, jOffset);
                                if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                    int size = protobufListMutableCopyWithCapacity2.size();
                                    protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe2.putObject(t12, jOffset, protobufListMutableCopyWithCapacity2);
                                }
                                iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), i42, bArr, i38, i11, protobufListMutableCopyWithCapacity2, registers);
                                i33 = iPositionForFieldNumber;
                                i34 = i42;
                                i37 = i22;
                                i35 = i21;
                                i36 = i19;
                                bArr3 = bArr;
                                i32 = i12;
                            } else {
                                i29 = i38;
                                unsafe = unsafe2;
                                i23 = iPositionForFieldNumber;
                                i30 = i42;
                                i13 = i12;
                                i20 = i29;
                            }
                        } else if (iType <= 49) {
                            int i47 = i38;
                            unsafe = unsafe2;
                            i23 = iPositionForFieldNumber;
                            i30 = i42;
                            iDecodeUnknownField = parseRepeatedField(t10, bArr, i38, i11, i42, i19, i40, iPositionForFieldNumber, i41, iType, jOffset, registers);
                            if (iDecodeUnknownField != i47) {
                                messageSchema2 = this;
                                t12 = t10;
                                bArr3 = bArr;
                                i31 = i11;
                                i32 = i12;
                                registers2 = registers;
                                i37 = i22;
                                i35 = i21;
                                i33 = i23;
                                i34 = i30;
                                i36 = i19;
                                unsafe2 = unsafe;
                            } else {
                                i13 = i12;
                                i20 = iDecodeUnknownField;
                            }
                        } else {
                            i29 = i38;
                            unsafe = unsafe2;
                            i23 = iPositionForFieldNumber;
                            i30 = i42;
                            if (iType != 50) {
                                iDecodeUnknownField = parseOneofField(t10, bArr, i29, i11, i30, i19, i40, i41, iType, jOffset, i23, registers);
                                if (iDecodeUnknownField != i29) {
                                    messageSchema2 = this;
                                    t12 = t10;
                                    bArr3 = bArr;
                                    i31 = i11;
                                    i32 = i12;
                                    registers2 = registers;
                                    i37 = i22;
                                    i35 = i21;
                                    i33 = i23;
                                    i34 = i30;
                                    i36 = i19;
                                    unsafe2 = unsafe;
                                } else {
                                    i13 = i12;
                                    i20 = iDecodeUnknownField;
                                }
                            } else if (i40 == 2) {
                                iDecodeUnknownField = parseMapField(t10, bArr, i29, i11, i23, jOffset, registers);
                                if (iDecodeUnknownField != i29) {
                                    messageSchema2 = this;
                                    t12 = t10;
                                    bArr3 = bArr;
                                    i31 = i11;
                                    i32 = i12;
                                    registers2 = registers;
                                    i37 = i22;
                                    i35 = i21;
                                    i33 = i23;
                                    i34 = i30;
                                    i36 = i19;
                                    unsafe2 = unsafe;
                                } else {
                                    i13 = i12;
                                    i20 = iDecodeUnknownField;
                                }
                            } else {
                                i13 = i12;
                                i20 = i29;
                            }
                        }
                        i15 = i30;
                    }
                }
                if (i15 != i13 || i13 == 0) {
                    iDecodeUnknownField = (!this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) ? ArrayDecoders.decodeUnknownField(i15, bArr, i20, i11, getMutableUnknownFields(t10), registers) : ArrayDecoders.decodeExtensionOrUnknownField(i15, bArr, i20, i11, t10, this.defaultInstance, this.unknownFieldSchema, registers);
                    t12 = t10;
                    bArr3 = bArr;
                    i31 = i11;
                    i34 = i15;
                    messageSchema2 = this;
                    registers2 = registers;
                    i37 = i22;
                    i35 = i21;
                    i33 = i23;
                    i36 = i19;
                    unsafe2 = unsafe;
                    i32 = i13;
                } else {
                    i17 = 1048575;
                    messageSchema = this;
                    i14 = i20;
                    i16 = i22;
                    i35 = i21;
                }
            } else {
                int i48 = i37;
                unsafe = unsafe2;
                i13 = i32;
                messageSchema = messageSchema2;
                i14 = iDecodeUnknownField;
                i15 = i34;
                i16 = i48;
                i17 = 1048575;
            }
        }
        if (i16 != i17) {
            t11 = t10;
            unsafe.putInt(t11, i16, i35);
        } else {
            t11 = t10;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i49 = messageSchema.checkInitializedCount; i49 < messageSchema.repeatedFieldOffsetStart; i49++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(t10, messageSchema.intArray[i49], unknownFieldSetLite, messageSchema.unknownFieldSchema, t10);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t11, unknownFieldSetLite);
        }
        if (i13 == 0) {
            if (i14 != i11) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i14 > i11 || i15 != i13) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i14;
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t10, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t10, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t10, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t10, writer);
        }
    }

    private boolean isFieldPresent(T t10, int i10) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i10);
        long j10 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j10 != 1048575) {
            return (UnsafeUtil.getInt(t10, j10) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i10);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t10, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t10, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t10, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t10, jOffset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(t10, jOffset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t10, jOffset));
            case 11:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t10, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private int positionForFieldNumber(int i10, int i11) {
        if (i10 < this.minFieldNumber || i10 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i10, i11);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t10, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        checkMutable(t10);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t10, reader, extensionRegistryLite);
    }

    private boolean equals(T t10, T t11, int i10) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i10);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (arePresentForEquals(t10, t11, i10) && Double.doubleToLongBits(UnsafeUtil.getDouble(t10, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t11, jOffset))) {
                    break;
                }
                break;
            case 1:
                if (arePresentForEquals(t10, t11, i10) && Float.floatToIntBits(UnsafeUtil.getFloat(t10, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t11, jOffset))) {
                    break;
                }
                break;
            case 2:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getLong(t10, jOffset) == UnsafeUtil.getLong(t11, jOffset)) {
                    break;
                }
                break;
            case 3:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getLong(t10, jOffset) == UnsafeUtil.getLong(t11, jOffset)) {
                    break;
                }
                break;
            case 4:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getInt(t10, jOffset) == UnsafeUtil.getInt(t11, jOffset)) {
                    break;
                }
                break;
            case 5:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getLong(t10, jOffset) == UnsafeUtil.getLong(t11, jOffset)) {
                    break;
                }
                break;
            case 6:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getInt(t10, jOffset) == UnsafeUtil.getInt(t11, jOffset)) {
                    break;
                }
                break;
            case 7:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getBoolean(t10, jOffset) == UnsafeUtil.getBoolean(t11, jOffset)) {
                    break;
                }
                break;
            case 8:
                if (arePresentForEquals(t10, t11, i10) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                    break;
                }
                break;
            case 9:
                if (arePresentForEquals(t10, t11, i10) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                    break;
                }
                break;
            case 10:
                if (arePresentForEquals(t10, t11, i10) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                    break;
                }
                break;
            case 11:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getInt(t10, jOffset) == UnsafeUtil.getInt(t11, jOffset)) {
                    break;
                }
                break;
            case 12:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getInt(t10, jOffset) == UnsafeUtil.getInt(t11, jOffset)) {
                    break;
                }
                break;
            case 13:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getInt(t10, jOffset) == UnsafeUtil.getInt(t11, jOffset)) {
                    break;
                }
                break;
            case 14:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getLong(t10, jOffset) == UnsafeUtil.getLong(t11, jOffset)) {
                    break;
                }
                break;
            case 15:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getInt(t10, jOffset) == UnsafeUtil.getInt(t11, jOffset)) {
                    break;
                }
                break;
            case 16:
                if (arePresentForEquals(t10, t11, i10) && UnsafeUtil.getLong(t10, jOffset) == UnsafeUtil.getLong(t11, jOffset)) {
                    break;
                }
                break;
            case 17:
                if (arePresentForEquals(t10, t11, i10) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                    break;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (isOneofCaseEqual(t10, t11, i10) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t10, byte[] bArr, int i10, int i11, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t10, bArr, i10, i11, registers);
        } else {
            parseProto2Message(t10, bArr, i10, i11, 0, registers);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i10, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i10)));
    }
}
