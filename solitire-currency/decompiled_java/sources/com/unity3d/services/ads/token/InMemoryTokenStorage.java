package com.unity3d.services.ads.token;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.GameSessionIdReader;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import s9.o0;
import s9.y;
import v8.k0;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: InMemoryTokenStorage.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InMemoryTokenStorage implements TokenStorage, IServiceComponent {

    @NotNull
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    @NotNull
    private final y<Integer> accessCounter = o0.a(-1);

    @NotNull
    private final y<String> initToken = o0.a(null);
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @NotNull
    private final l asyncTokenStorage$delegate = n.b(p.f35203c, new InMemoryTokenStorage$special$$inlined$inject$default$1(this, ""));

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _get_nativeGeneratedToken_$lambda$2(String str) {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_NATIVE_DATA, str);
    }

    private final AsyncTokenStorage getAsyncTokenStorage() {
        return (AsyncTokenStorage) this.asyncTokenStorage$delegate.getValue();
    }

    private final void triggerTokenAvailable(boolean z10) {
        InitializeEventsMetricSender.getInstance().sdkTokenDidBecomeAvailableWithConfig(z10);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void appendTokens(@NotNull JSONArray tokens) throws JSONException {
        t.i(tokens, "tokens");
        this.accessCounter.d(-1, 0);
        int length = tokens.length();
        for (int i10 = 0; i10 < length; i10++) {
            this.queue.add(tokens.getString(i10));
        }
        if (length > 0) {
            triggerTokenAvailable(false);
            getAsyncTokenStorage().onTokenAvailable();
        }
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void createTokens(@NotNull JSONArray tokens) throws JSONException {
        t.i(tokens, "tokens");
        deleteTokens();
        appendTokens(tokens);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void deleteTokens() {
        Integer value;
        this.queue.clear();
        y<Integer> yVar = this.accessCounter;
        do {
            value = yVar.getValue();
            value.intValue();
        } while (!yVar.d(value, -1));
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    @NotNull
    public k0 getNativeGeneratedToken() {
        new NativeTokenGenerator(this.executorService, new DeviceInfoReaderBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()), null).generateToken(new INativeTokenGeneratorListener() { // from class: com.unity3d.services.ads.token.a
            @Override // com.unity3d.services.ads.token.INativeTokenGeneratorListener
            public final void onReady(String str) {
                InMemoryTokenStorage._get_nativeGeneratedToken_$lambda$2(str);
            }
        });
        return k0.f35197a;
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    @NotNull
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    @Nullable
    public String getToken() {
        Integer value;
        Integer num;
        if (this.accessCounter.getValue().intValue() == -1) {
            return this.initToken.getValue();
        }
        if (this.queue.isEmpty()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.QUEUE_EMPTY, new Object[0]);
            return null;
        }
        y<Integer> yVar = this.accessCounter;
        do {
            value = yVar.getValue();
            num = value;
        } while (!yVar.d(value, Integer.valueOf(num.intValue() + 1)));
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_ACCESS, Integer.valueOf(num.intValue()));
        return this.queue.poll();
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void setInitToken(@Nullable String str) {
        if (str == null) {
            return;
        }
        y<String> yVar = this.initToken;
        while (!yVar.d(yVar.getValue(), str)) {
        }
        triggerTokenAvailable(true);
        getAsyncTokenStorage().onTokenAvailable();
    }
}
