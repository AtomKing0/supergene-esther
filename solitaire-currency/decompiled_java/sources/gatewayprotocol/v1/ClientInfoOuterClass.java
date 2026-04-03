package gatewayprotocol.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class ClientInfoOuterClass {

    public static final class ClientInfo extends GeneratedMessageLite<ClientInfo, Builder> implements ClientInfoOrBuilder {
        public static final int CUSTOM_MEDIATION_NAME_FIELD_NUMBER = 7;
        private static final ClientInfo DEFAULT_INSTANCE;
        public static final int GAME_ID_FIELD_NUMBER = 3;
        public static final int MEDIATION_PROVIDER_FIELD_NUMBER = 6;
        public static final int MEDIATION_VERSION_FIELD_NUMBER = 8;
        public static final int OMID_PARTNER_VERSION_FIELD_NUMBER = 9;
        public static final int OMID_VERSION_FIELD_NUMBER = 10;
        private static volatile Parser<ClientInfo> PARSER = null;
        public static final int PLATFORM_FIELD_NUMBER = 5;
        public static final int SCAR_VERSION_NAME_FIELD_NUMBER = 12;
        public static final int SDK_DEVELOPMENT_PLATFORM_FIELD_NUMBER = 11;
        public static final int SDK_VERSION_FIELD_NUMBER = 1;
        public static final int SDK_VERSION_NAME_FIELD_NUMBER = 2;
        public static final int TEST_FIELD_NUMBER = 4;
        private int bitField0_;
        private int mediationProvider_;
        private int platform_;
        private int sdkVersion_;
        private boolean test_;
        private String sdkVersionName_ = "";
        private String gameId_ = "";
        private String customMediationName_ = "";
        private String mediationVersion_ = "";
        private String omidPartnerVersion_ = "";
        private String omidVersion_ = "";
        private String sdkDevelopmentPlatform_ = "";
        private String scarVersionName_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ClientInfo, Builder> implements ClientInfoOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            public Builder clearCustomMediationName() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearCustomMediationName();
                return this;
            }

            public Builder clearGameId() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearGameId();
                return this;
            }

            public Builder clearMediationProvider() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearMediationProvider();
                return this;
            }

            public Builder clearMediationVersion() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearMediationVersion();
                return this;
            }

            public Builder clearOmidPartnerVersion() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearOmidPartnerVersion();
                return this;
            }

            public Builder clearOmidVersion() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearOmidVersion();
                return this;
            }

            public Builder clearPlatform() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearPlatform();
                return this;
            }

            public Builder clearScarVersionName() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearScarVersionName();
                return this;
            }

            public Builder clearSdkDevelopmentPlatform() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearSdkDevelopmentPlatform();
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearSdkVersion();
                return this;
            }

            public Builder clearSdkVersionName() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearSdkVersionName();
                return this;
            }

            public Builder clearTest() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearTest();
                return this;
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getCustomMediationName() {
                return ((ClientInfo) this.instance).getCustomMediationName();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getCustomMediationNameBytes() {
                return ((ClientInfo) this.instance).getCustomMediationNameBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getGameId() {
                return ((ClientInfo) this.instance).getGameId();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getGameIdBytes() {
                return ((ClientInfo) this.instance).getGameIdBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public MediationProvider getMediationProvider() {
                return ((ClientInfo) this.instance).getMediationProvider();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public int getMediationProviderValue() {
                return ((ClientInfo) this.instance).getMediationProviderValue();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getMediationVersion() {
                return ((ClientInfo) this.instance).getMediationVersion();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getMediationVersionBytes() {
                return ((ClientInfo) this.instance).getMediationVersionBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getOmidPartnerVersion() {
                return ((ClientInfo) this.instance).getOmidPartnerVersion();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getOmidPartnerVersionBytes() {
                return ((ClientInfo) this.instance).getOmidPartnerVersionBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getOmidVersion() {
                return ((ClientInfo) this.instance).getOmidVersion();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getOmidVersionBytes() {
                return ((ClientInfo) this.instance).getOmidVersionBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public Platform getPlatform() {
                return ((ClientInfo) this.instance).getPlatform();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public int getPlatformValue() {
                return ((ClientInfo) this.instance).getPlatformValue();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getScarVersionName() {
                return ((ClientInfo) this.instance).getScarVersionName();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getScarVersionNameBytes() {
                return ((ClientInfo) this.instance).getScarVersionNameBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getSdkDevelopmentPlatform() {
                return ((ClientInfo) this.instance).getSdkDevelopmentPlatform();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getSdkDevelopmentPlatformBytes() {
                return ((ClientInfo) this.instance).getSdkDevelopmentPlatformBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public int getSdkVersion() {
                return ((ClientInfo) this.instance).getSdkVersion();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public String getSdkVersionName() {
                return ((ClientInfo) this.instance).getSdkVersionName();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public ByteString getSdkVersionNameBytes() {
                return ((ClientInfo) this.instance).getSdkVersionNameBytes();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public boolean getTest() {
                return ((ClientInfo) this.instance).getTest();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public boolean hasCustomMediationName() {
                return ((ClientInfo) this.instance).hasCustomMediationName();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public boolean hasMediationVersion() {
                return ((ClientInfo) this.instance).hasMediationVersion();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public boolean hasOmidPartnerVersion() {
                return ((ClientInfo) this.instance).hasOmidPartnerVersion();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public boolean hasOmidVersion() {
                return ((ClientInfo) this.instance).hasOmidVersion();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public boolean hasScarVersionName() {
                return ((ClientInfo) this.instance).hasScarVersionName();
            }

            @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
            public boolean hasSdkDevelopmentPlatform() {
                return ((ClientInfo) this.instance).hasSdkDevelopmentPlatform();
            }

            public Builder setCustomMediationName(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setCustomMediationName(str);
                return this;
            }

            public Builder setCustomMediationNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setCustomMediationNameBytes(byteString);
                return this;
            }

            public Builder setGameId(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setGameId(str);
                return this;
            }

            public Builder setGameIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setGameIdBytes(byteString);
                return this;
            }

            public Builder setMediationProvider(MediationProvider mediationProvider) {
                copyOnWrite();
                ((ClientInfo) this.instance).setMediationProvider(mediationProvider);
                return this;
            }

            public Builder setMediationProviderValue(int i10) {
                copyOnWrite();
                ((ClientInfo) this.instance).setMediationProviderValue(i10);
                return this;
            }

            public Builder setMediationVersion(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setMediationVersion(str);
                return this;
            }

            public Builder setMediationVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setMediationVersionBytes(byteString);
                return this;
            }

            public Builder setOmidPartnerVersion(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setOmidPartnerVersion(str);
                return this;
            }

            public Builder setOmidPartnerVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setOmidPartnerVersionBytes(byteString);
                return this;
            }

            public Builder setOmidVersion(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setOmidVersion(str);
                return this;
            }

            public Builder setOmidVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setOmidVersionBytes(byteString);
                return this;
            }

            public Builder setPlatform(Platform platform) {
                copyOnWrite();
                ((ClientInfo) this.instance).setPlatform(platform);
                return this;
            }

            public Builder setPlatformValue(int i10) {
                copyOnWrite();
                ((ClientInfo) this.instance).setPlatformValue(i10);
                return this;
            }

            public Builder setScarVersionName(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setScarVersionName(str);
                return this;
            }

            public Builder setScarVersionNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setScarVersionNameBytes(byteString);
                return this;
            }

            public Builder setSdkDevelopmentPlatform(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setSdkDevelopmentPlatform(str);
                return this;
            }

            public Builder setSdkDevelopmentPlatformBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setSdkDevelopmentPlatformBytes(byteString);
                return this;
            }

            public Builder setSdkVersion(int i10) {
                copyOnWrite();
                ((ClientInfo) this.instance).setSdkVersion(i10);
                return this;
            }

            public Builder setSdkVersionName(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setSdkVersionName(str);
                return this;
            }

            public Builder setSdkVersionNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setSdkVersionNameBytes(byteString);
                return this;
            }

            public Builder setTest(boolean z10) {
                copyOnWrite();
                ((ClientInfo) this.instance).setTest(z10);
                return this;
            }

            private Builder() {
                super(ClientInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            ClientInfo clientInfo = new ClientInfo();
            DEFAULT_INSTANCE = clientInfo;
            GeneratedMessageLite.registerDefaultInstance(ClientInfo.class, clientInfo);
        }

        private ClientInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCustomMediationName() {
            this.bitField0_ &= -2;
            this.customMediationName_ = getDefaultInstance().getCustomMediationName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGameId() {
            this.gameId_ = getDefaultInstance().getGameId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMediationProvider() {
            this.mediationProvider_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMediationVersion() {
            this.bitField0_ &= -3;
            this.mediationVersion_ = getDefaultInstance().getMediationVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOmidPartnerVersion() {
            this.bitField0_ &= -5;
            this.omidPartnerVersion_ = getDefaultInstance().getOmidPartnerVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOmidVersion() {
            this.bitField0_ &= -9;
            this.omidVersion_ = getDefaultInstance().getOmidVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlatform() {
            this.platform_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScarVersionName() {
            this.bitField0_ &= -33;
            this.scarVersionName_ = getDefaultInstance().getScarVersionName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkDevelopmentPlatform() {
            this.bitField0_ &= -17;
            this.sdkDevelopmentPlatform_ = getDefaultInstance().getSdkDevelopmentPlatform();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkVersion() {
            this.sdkVersion_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkVersionName() {
            this.sdkVersionName_ = getDefaultInstance().getSdkVersionName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTest() {
            this.test_ = false;
        }

        public static ClientInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ClientInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ClientInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCustomMediationName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.customMediationName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCustomMediationNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.customMediationName_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGameId(String str) {
            str.getClass();
            this.gameId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGameIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.gameId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMediationProvider(MediationProvider mediationProvider) {
            this.mediationProvider_ = mediationProvider.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMediationProviderValue(int i10) {
            this.mediationProvider_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMediationVersion(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.mediationVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMediationVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mediationVersion_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOmidPartnerVersion(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.omidPartnerVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOmidPartnerVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.omidPartnerVersion_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOmidVersion(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.omidVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOmidVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.omidVersion_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatform(Platform platform) {
            this.platform_ = platform.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformValue(int i10) {
            this.platform_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScarVersionName(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.scarVersionName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScarVersionNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.scarVersionName_ = byteString.toStringUtf8();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkDevelopmentPlatform(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.sdkDevelopmentPlatform_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkDevelopmentPlatformBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sdkDevelopmentPlatform_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersion(int i10) {
            this.sdkVersion_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersionName(String str) {
            str.getClass();
            this.sdkVersionName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersionNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sdkVersionName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTest(boolean z10) {
            this.test_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f26330a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ClientInfo();
                case 2:
                    return new Builder(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\u000b\u0002Ȉ\u0003Ȉ\u0004\u0007\u0005\f\u0006\f\u0007ለ\u0000\bለ\u0001\tለ\u0002\nለ\u0003\u000bለ\u0004\fለ\u0005", new Object[]{"bitField0_", "sdkVersion_", "sdkVersionName_", "gameId_", "test_", "platform_", "mediationProvider_", "customMediationName_", "mediationVersion_", "omidPartnerVersion_", "omidVersion_", "sdkDevelopmentPlatform_", "scarVersionName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClientInfo> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ClientInfo.class) {
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

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getCustomMediationName() {
            return this.customMediationName_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getCustomMediationNameBytes() {
            return ByteString.copyFromUtf8(this.customMediationName_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getGameId() {
            return this.gameId_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getGameIdBytes() {
            return ByteString.copyFromUtf8(this.gameId_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public MediationProvider getMediationProvider() {
            MediationProvider mediationProviderForNumber = MediationProvider.forNumber(this.mediationProvider_);
            return mediationProviderForNumber == null ? MediationProvider.UNRECOGNIZED : mediationProviderForNumber;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public int getMediationProviderValue() {
            return this.mediationProvider_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getMediationVersion() {
            return this.mediationVersion_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getMediationVersionBytes() {
            return ByteString.copyFromUtf8(this.mediationVersion_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getOmidPartnerVersion() {
            return this.omidPartnerVersion_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getOmidPartnerVersionBytes() {
            return ByteString.copyFromUtf8(this.omidPartnerVersion_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getOmidVersion() {
            return this.omidVersion_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getOmidVersionBytes() {
            return ByteString.copyFromUtf8(this.omidVersion_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public Platform getPlatform() {
            Platform platformForNumber = Platform.forNumber(this.platform_);
            return platformForNumber == null ? Platform.UNRECOGNIZED : platformForNumber;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public int getPlatformValue() {
            return this.platform_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getScarVersionName() {
            return this.scarVersionName_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getScarVersionNameBytes() {
            return ByteString.copyFromUtf8(this.scarVersionName_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getSdkDevelopmentPlatform() {
            return this.sdkDevelopmentPlatform_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getSdkDevelopmentPlatformBytes() {
            return ByteString.copyFromUtf8(this.sdkDevelopmentPlatform_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public int getSdkVersion() {
            return this.sdkVersion_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public String getSdkVersionName() {
            return this.sdkVersionName_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public ByteString getSdkVersionNameBytes() {
            return ByteString.copyFromUtf8(this.sdkVersionName_);
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public boolean getTest() {
            return this.test_;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public boolean hasCustomMediationName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public boolean hasMediationVersion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public boolean hasOmidPartnerVersion() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public boolean hasOmidVersion() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public boolean hasScarVersionName() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // gatewayprotocol.v1.ClientInfoOuterClass.ClientInfoOrBuilder
        public boolean hasSdkDevelopmentPlatform() {
            return (this.bitField0_ & 16) != 0;
        }

        public static Builder newBuilder(ClientInfo clientInfo) {
            return DEFAULT_INSTANCE.createBuilder(clientInfo);
        }

        public static ClientInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ClientInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClientInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(InputStream inputStream) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ClientInfoOrBuilder extends MessageLiteOrBuilder {
        String getCustomMediationName();

        ByteString getCustomMediationNameBytes();

        String getGameId();

        ByteString getGameIdBytes();

        MediationProvider getMediationProvider();

        int getMediationProviderValue();

        String getMediationVersion();

        ByteString getMediationVersionBytes();

        String getOmidPartnerVersion();

        ByteString getOmidPartnerVersionBytes();

        String getOmidVersion();

        ByteString getOmidVersionBytes();

        Platform getPlatform();

        int getPlatformValue();

        String getScarVersionName();

        ByteString getScarVersionNameBytes();

        String getSdkDevelopmentPlatform();

        ByteString getSdkDevelopmentPlatformBytes();

        int getSdkVersion();

        String getSdkVersionName();

        ByteString getSdkVersionNameBytes();

        boolean getTest();

        boolean hasCustomMediationName();

        boolean hasMediationVersion();

        boolean hasOmidPartnerVersion();

        boolean hasOmidVersion();

        boolean hasScarVersionName();

        boolean hasSdkDevelopmentPlatform();
    }

    public enum MediationProvider implements Internal.EnumLite {
        MEDIATION_PROVIDER_UNSPECIFIED(0),
        MEDIATION_PROVIDER_CUSTOM(1),
        MEDIATION_PROVIDER_ADMOB(2),
        MEDIATION_PROVIDER_MAX(3),
        MEDIATION_PROVIDER_LEVELPLAY(4),
        UNRECOGNIZED(-1);

        public static final int MEDIATION_PROVIDER_ADMOB_VALUE = 2;
        public static final int MEDIATION_PROVIDER_CUSTOM_VALUE = 1;
        public static final int MEDIATION_PROVIDER_LEVELPLAY_VALUE = 4;
        public static final int MEDIATION_PROVIDER_MAX_VALUE = 3;
        public static final int MEDIATION_PROVIDER_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<MediationProvider> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap<MediationProvider> {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediationProvider findValueByNumber(int i10) {
                return MediationProvider.forNumber(i10);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f26328a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return MediationProvider.forNumber(i10) != null;
            }
        }

        MediationProvider(int i10) {
            this.value = i10;
        }

        public static MediationProvider forNumber(int i10) {
            if (i10 == 0) {
                return MEDIATION_PROVIDER_UNSPECIFIED;
            }
            if (i10 == 1) {
                return MEDIATION_PROVIDER_CUSTOM;
            }
            if (i10 == 2) {
                return MEDIATION_PROVIDER_ADMOB;
            }
            if (i10 == 3) {
                return MEDIATION_PROVIDER_MAX;
            }
            if (i10 != 4) {
                return null;
            }
            return MEDIATION_PROVIDER_LEVELPLAY;
        }

        public static Internal.EnumLiteMap<MediationProvider> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f26328a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MediationProvider valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public enum Platform implements Internal.EnumLite {
        PLATFORM_UNSPECIFIED(0),
        PLATFORM_ANDROID(1),
        PLATFORM_IOS(2),
        UNRECOGNIZED(-1);

        public static final int PLATFORM_ANDROID_VALUE = 1;
        public static final int PLATFORM_IOS_VALUE = 2;
        public static final int PLATFORM_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<Platform> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap<Platform> {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Platform findValueByNumber(int i10) {
                return Platform.forNumber(i10);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f26329a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return Platform.forNumber(i10) != null;
            }
        }

        Platform(int i10) {
            this.value = i10;
        }

        public static Platform forNumber(int i10) {
            if (i10 == 0) {
                return PLATFORM_UNSPECIFIED;
            }
            if (i10 == 1) {
                return PLATFORM_ANDROID;
            }
            if (i10 != 2) {
                return null;
            }
            return PLATFORM_IOS;
        }

        public static Internal.EnumLiteMap<Platform> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f26329a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Platform valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26330a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f26330a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26330a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26330a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26330a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26330a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26330a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26330a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private ClientInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
