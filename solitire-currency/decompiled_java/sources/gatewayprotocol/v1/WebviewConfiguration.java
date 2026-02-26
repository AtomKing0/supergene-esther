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
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class WebviewConfiguration {

    public static final class WebViewConfiguration extends GeneratedMessageLite<WebViewConfiguration, Builder> implements WebViewConfigurationOrBuilder {
        public static final int ADDITIONAL_FILES_FIELD_NUMBER = 3;
        private static final WebViewConfiguration DEFAULT_INSTANCE;
        public static final int ENTRY_POINT_FIELD_NUMBER = 2;
        private static volatile Parser<WebViewConfiguration> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 1;
        private int version_;
        private String entryPoint_ = "";
        private Internal.ProtobufList<String> additionalFiles_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<WebViewConfiguration, Builder> implements WebViewConfigurationOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            public Builder addAdditionalFiles(String str) {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).addAdditionalFiles(str);
                return this;
            }

            public Builder addAdditionalFilesBytes(ByteString byteString) {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).addAdditionalFilesBytes(byteString);
                return this;
            }

            public Builder addAllAdditionalFiles(Iterable<String> iterable) {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).addAllAdditionalFiles(iterable);
                return this;
            }

            public Builder clearAdditionalFiles() {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).clearAdditionalFiles();
                return this;
            }

            public Builder clearEntryPoint() {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).clearEntryPoint();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).clearVersion();
                return this;
            }

            @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
            public String getAdditionalFiles(int i10) {
                return ((WebViewConfiguration) this.instance).getAdditionalFiles(i10);
            }

            @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
            public ByteString getAdditionalFilesBytes(int i10) {
                return ((WebViewConfiguration) this.instance).getAdditionalFilesBytes(i10);
            }

            @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
            public int getAdditionalFilesCount() {
                return ((WebViewConfiguration) this.instance).getAdditionalFilesCount();
            }

            @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
            public List<String> getAdditionalFilesList() {
                return Collections.unmodifiableList(((WebViewConfiguration) this.instance).getAdditionalFilesList());
            }

            @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
            public String getEntryPoint() {
                return ((WebViewConfiguration) this.instance).getEntryPoint();
            }

            @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
            public ByteString getEntryPointBytes() {
                return ((WebViewConfiguration) this.instance).getEntryPointBytes();
            }

            @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
            public int getVersion() {
                return ((WebViewConfiguration) this.instance).getVersion();
            }

            public Builder setAdditionalFiles(int i10, String str) {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).setAdditionalFiles(i10, str);
                return this;
            }

            public Builder setEntryPoint(String str) {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).setEntryPoint(str);
                return this;
            }

            public Builder setEntryPointBytes(ByteString byteString) {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).setEntryPointBytes(byteString);
                return this;
            }

            public Builder setVersion(int i10) {
                copyOnWrite();
                ((WebViewConfiguration) this.instance).setVersion(i10);
                return this;
            }

            private Builder() {
                super(WebViewConfiguration.DEFAULT_INSTANCE);
            }
        }

        static {
            WebViewConfiguration webViewConfiguration = new WebViewConfiguration();
            DEFAULT_INSTANCE = webViewConfiguration;
            GeneratedMessageLite.registerDefaultInstance(WebViewConfiguration.class, webViewConfiguration);
        }

        private WebViewConfiguration() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAdditionalFiles(String str) {
            str.getClass();
            ensureAdditionalFilesIsMutable();
            this.additionalFiles_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAdditionalFilesBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureAdditionalFilesIsMutable();
            this.additionalFiles_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAdditionalFiles(Iterable<String> iterable) {
            ensureAdditionalFilesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.additionalFiles_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdditionalFiles() {
            this.additionalFiles_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEntryPoint() {
            this.entryPoint_ = getDefaultInstance().getEntryPoint();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = 0;
        }

        private void ensureAdditionalFilesIsMutable() {
            Internal.ProtobufList<String> protobufList = this.additionalFiles_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.additionalFiles_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static WebViewConfiguration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static WebViewConfiguration parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WebViewConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WebViewConfiguration parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<WebViewConfiguration> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdditionalFiles(int i10, String str) {
            str.getClass();
            ensureAdditionalFilesIsMutable();
            this.additionalFiles_.set(i10, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEntryPoint(String str) {
            str.getClass();
            this.entryPoint_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEntryPointBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.entryPoint_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(int i10) {
            this.version_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f26371a[methodToInvoke.ordinal()]) {
                case 1:
                    return new WebViewConfiguration();
                case 2:
                    return new Builder(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ț", new Object[]{"version_", "entryPoint_", "additionalFiles_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<WebViewConfiguration> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (WebViewConfiguration.class) {
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

        @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
        public String getAdditionalFiles(int i10) {
            return this.additionalFiles_.get(i10);
        }

        @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
        public ByteString getAdditionalFilesBytes(int i10) {
            return ByteString.copyFromUtf8(this.additionalFiles_.get(i10));
        }

        @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
        public int getAdditionalFilesCount() {
            return this.additionalFiles_.size();
        }

        @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
        public List<String> getAdditionalFilesList() {
            return this.additionalFiles_;
        }

        @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
        public String getEntryPoint() {
            return this.entryPoint_;
        }

        @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
        public ByteString getEntryPointBytes() {
            return ByteString.copyFromUtf8(this.entryPoint_);
        }

        @Override // gatewayprotocol.v1.WebviewConfiguration.WebViewConfigurationOrBuilder
        public int getVersion() {
            return this.version_;
        }

        public static Builder newBuilder(WebViewConfiguration webViewConfiguration) {
            return DEFAULT_INSTANCE.createBuilder(webViewConfiguration);
        }

        public static WebViewConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WebViewConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WebViewConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WebViewConfiguration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WebViewConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WebViewConfiguration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WebViewConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WebViewConfiguration parseFrom(InputStream inputStream) throws IOException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WebViewConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WebViewConfiguration parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WebViewConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WebViewConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface WebViewConfigurationOrBuilder extends MessageLiteOrBuilder {
        String getAdditionalFiles(int i10);

        ByteString getAdditionalFilesBytes(int i10);

        int getAdditionalFilesCount();

        List<String> getAdditionalFilesList();

        String getEntryPoint();

        ByteString getEntryPointBytes();

        int getVersion();
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26371a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f26371a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26371a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26371a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26371a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26371a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26371a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26371a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private WebviewConfiguration() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
