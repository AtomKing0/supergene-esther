package gatewayprotocol.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class TestDataOuterClass {

    public static final class TestData extends GeneratedMessageLite<TestData, Builder> implements TestDataOrBuilder {
        private static final TestData DEFAULT_INSTANCE;
        public static final int FORCE_CAMPAIGN_ID_FIELD_NUMBER = 1;
        public static final int FORCE_COUNTRY_FIELD_NUMBER = 2;
        public static final int FORCE_COUNTRY_SUBDIVISION_FIELD_NUMBER = 3;
        private static volatile Parser<TestData> PARSER;
        private int bitField0_;
        private String forceCampaignId_ = "";
        private String forceCountry_ = "";
        private String forceCountrySubdivision_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<TestData, Builder> implements TestDataOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            public Builder clearForceCampaignId() {
                copyOnWrite();
                ((TestData) this.instance).clearForceCampaignId();
                return this;
            }

            public Builder clearForceCountry() {
                copyOnWrite();
                ((TestData) this.instance).clearForceCountry();
                return this;
            }

            public Builder clearForceCountrySubdivision() {
                copyOnWrite();
                ((TestData) this.instance).clearForceCountrySubdivision();
                return this;
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public String getForceCampaignId() {
                return ((TestData) this.instance).getForceCampaignId();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public ByteString getForceCampaignIdBytes() {
                return ((TestData) this.instance).getForceCampaignIdBytes();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public String getForceCountry() {
                return ((TestData) this.instance).getForceCountry();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public ByteString getForceCountryBytes() {
                return ((TestData) this.instance).getForceCountryBytes();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public String getForceCountrySubdivision() {
                return ((TestData) this.instance).getForceCountrySubdivision();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public ByteString getForceCountrySubdivisionBytes() {
                return ((TestData) this.instance).getForceCountrySubdivisionBytes();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public boolean hasForceCampaignId() {
                return ((TestData) this.instance).hasForceCampaignId();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public boolean hasForceCountry() {
                return ((TestData) this.instance).hasForceCountry();
            }

            @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
            public boolean hasForceCountrySubdivision() {
                return ((TestData) this.instance).hasForceCountrySubdivision();
            }

            public Builder setForceCampaignId(String str) {
                copyOnWrite();
                ((TestData) this.instance).setForceCampaignId(str);
                return this;
            }

            public Builder setForceCampaignIdBytes(ByteString byteString) {
                copyOnWrite();
                ((TestData) this.instance).setForceCampaignIdBytes(byteString);
                return this;
            }

            public Builder setForceCountry(String str) {
                copyOnWrite();
                ((TestData) this.instance).setForceCountry(str);
                return this;
            }

            public Builder setForceCountryBytes(ByteString byteString) {
                copyOnWrite();
                ((TestData) this.instance).setForceCountryBytes(byteString);
                return this;
            }

            public Builder setForceCountrySubdivision(String str) {
                copyOnWrite();
                ((TestData) this.instance).setForceCountrySubdivision(str);
                return this;
            }

            public Builder setForceCountrySubdivisionBytes(ByteString byteString) {
                copyOnWrite();
                ((TestData) this.instance).setForceCountrySubdivisionBytes(byteString);
                return this;
            }

            private Builder() {
                super(TestData.DEFAULT_INSTANCE);
            }
        }

        static {
            TestData testData = new TestData();
            DEFAULT_INSTANCE = testData;
            GeneratedMessageLite.registerDefaultInstance(TestData.class, testData);
        }

        private TestData() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearForceCampaignId() {
            this.bitField0_ &= -2;
            this.forceCampaignId_ = getDefaultInstance().getForceCampaignId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearForceCountry() {
            this.bitField0_ &= -3;
            this.forceCountry_ = getDefaultInstance().getForceCountry();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearForceCountrySubdivision() {
            this.bitField0_ &= -5;
            this.forceCountrySubdivision_ = getDefaultInstance().getForceCountrySubdivision();
        }

        public static TestData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TestData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TestData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TestData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<TestData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForceCampaignId(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.forceCampaignId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForceCampaignIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.forceCampaignId_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForceCountry(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.forceCountry_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForceCountryBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.forceCountry_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForceCountrySubdivision(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.forceCountrySubdivision_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForceCountrySubdivisionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.forceCountrySubdivision_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f26364a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TestData();
                case 2:
                    return new Builder(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002", new Object[]{"bitField0_", "forceCampaignId_", "forceCountry_", "forceCountrySubdivision_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TestData> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (TestData.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public String getForceCampaignId() {
            return this.forceCampaignId_;
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public ByteString getForceCampaignIdBytes() {
            return ByteString.copyFromUtf8(this.forceCampaignId_);
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public String getForceCountry() {
            return this.forceCountry_;
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public ByteString getForceCountryBytes() {
            return ByteString.copyFromUtf8(this.forceCountry_);
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public String getForceCountrySubdivision() {
            return this.forceCountrySubdivision_;
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public ByteString getForceCountrySubdivisionBytes() {
            return ByteString.copyFromUtf8(this.forceCountrySubdivision_);
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public boolean hasForceCampaignId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public boolean hasForceCountry() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // gatewayprotocol.v1.TestDataOuterClass.TestDataOrBuilder
        public boolean hasForceCountrySubdivision() {
            return (this.bitField0_ & 4) != 0;
        }

        public static Builder newBuilder(TestData testData) {
            return DEFAULT_INSTANCE.createBuilder(testData);
        }

        public static TestData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TestData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TestData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TestData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TestData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TestData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TestData parseFrom(InputStream inputStream) throws IOException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TestData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TestData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TestData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface TestDataOrBuilder extends MessageLiteOrBuilder {
        String getForceCampaignId();

        ByteString getForceCampaignIdBytes();

        String getForceCountry();

        ByteString getForceCountryBytes();

        String getForceCountrySubdivision();

        ByteString getForceCountrySubdivisionBytes();

        boolean hasForceCampaignId();

        boolean hasForceCountry();

        boolean hasForceCountrySubdivision();
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26364a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f26364a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26364a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26364a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26364a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26364a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26364a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26364a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private TestDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
