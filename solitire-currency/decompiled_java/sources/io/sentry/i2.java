package io.sentry;

import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.b4;
import io.sentry.b7;
import io.sentry.c7;
import io.sentry.c9;
import io.sentry.clientreport.c;
import io.sentry.e8;
import io.sentry.f7;
import io.sentry.g5;
import io.sentry.j8;
import io.sentry.o8;
import io.sentry.p7;
import io.sentry.profilemeasurements.a;
import io.sentry.profilemeasurements.b;
import io.sentry.protocol.App;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Device;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.Geo;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.Message;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkInfo;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryPackage;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.q5;
import io.sentry.q6;
import io.sentry.q8;
import io.sentry.r6;
import io.sentry.rrweb.a;
import io.sentry.rrweb.c;
import io.sentry.rrweb.e;
import io.sentry.rrweb.f;
import io.sentry.rrweb.g;
import io.sentry.rrweb.h;
import io.sentry.rrweb.i;
import io.sentry.t3;
import io.sentry.u3;
import io.sentry.x3;
import io.sentry.y3;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonSerializer.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i2 implements l1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Charset f27885c = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<Class<?>, x1<?>> f27887b;

    public i2(@NotNull SentryOptions sentryOptions) {
        this.f27886a = sentryOptions;
        HashMap map = new HashMap();
        this.f27887b = map;
        map.put(App.class, new App.Deserializer());
        map.put(Breadcrumb.class, new Breadcrumb.a());
        map.put(Browser.class, new Browser.Deserializer());
        map.put(Contexts.class, new Contexts.Deserializer());
        map.put(DebugImage.class, new DebugImage.Deserializer());
        map.put(DebugMeta.class, new DebugMeta.Deserializer());
        map.put(Device.class, new Device.Deserializer());
        map.put(Device.DeviceOrientation.class, new Device.DeviceOrientation.Deserializer());
        map.put(Feedback.class, new Feedback.Deserializer());
        map.put(Gpu.class, new Gpu.Deserializer());
        map.put(MeasurementValue.class, new MeasurementValue.Deserializer());
        map.put(Mechanism.class, new Mechanism.Deserializer());
        map.put(Message.class, new Message.Deserializer());
        map.put(OperatingSystem.class, new OperatingSystem.Deserializer());
        map.put(t3.class, new t3.b());
        map.put(u3.class, new u3.a());
        map.put(x3.class, new x3.b());
        map.put(y3.class, new y3.a());
        map.put(io.sentry.profilemeasurements.a.class, new a.C0585a());
        map.put(io.sentry.profilemeasurements.b.class, new b.a());
        map.put(Request.class, new Request.Deserializer());
        map.put(b4.class, new b4.b());
        map.put(io.sentry.rrweb.a.class, new a.C0586a());
        map.put(io.sentry.rrweb.c.class, new c.a());
        map.put(io.sentry.rrweb.e.class, new e.a());
        map.put(io.sentry.rrweb.f.class, new f.a());
        map.put(io.sentry.rrweb.g.class, new g.a());
        map.put(io.sentry.rrweb.h.class, new h.a());
        map.put(io.sentry.rrweb.i.class, new i.a());
        map.put(SdkInfo.class, new SdkInfo.Deserializer());
        map.put(SdkVersion.class, new SdkVersion.Deserializer());
        map.put(q5.class, new q5.a());
        map.put(q6.class, new q6.a());
        map.put(r6.class, new r6.a());
        map.put(SentryException.class, new SentryException.Deserializer());
        map.put(b7.class, new b7.a());
        map.put(SentryLevel.class, new SentryLevel.a());
        map.put(c7.class, new c7.a());
        map.put(f7.class, new f7.a());
        map.put(SentryPackage.class, new SentryPackage.Deserializer());
        map.put(SentryRuntime.class, new SentryRuntime.Deserializer());
        map.put(p7.class, new p7.a());
        map.put(SentrySpan.class, new SentrySpan.Deserializer());
        map.put(SentryStackFrame.class, new SentryStackFrame.Deserializer());
        map.put(SentryStackTrace.class, new SentryStackTrace.Deserializer());
        map.put(g5.class, new g5.a());
        map.put(SentryThread.class, new SentryThread.Deserializer());
        map.put(SentryTransaction.class, new SentryTransaction.Deserializer());
        map.put(e8.class, new e8.a());
        map.put(j8.class, new j8.a());
        map.put(o8.class, new o8.a());
        map.put(q8.class, new q8.a());
        map.put(User.class, new User.Deserializer());
        map.put(Geo.class, new Geo.Deserializer());
        map.put(c9.class, new c9.a());
        map.put(io.sentry.clientreport.c.class, new c.a());
        map.put(ViewHierarchyNode.class, new ViewHierarchyNode.Deserializer());
        map.put(ViewHierarchy.class, new ViewHierarchy.Deserializer());
    }

    private <T> boolean g(@NotNull Class<T> cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls) || String.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    @NotNull
    private String h(Object obj, boolean z10) throws IOException {
        StringWriter stringWriter = new StringWriter();
        f2 f2Var = new f2(stringWriter, this.f27886a.getMaxDepth());
        if (z10) {
            f2Var.m("\t");
        }
        f2Var.o(this.f27886a.getLogger(), obj);
        return stringWriter.toString();
    }

    @Override // io.sentry.l1
    public <T> void a(@NotNull T t10, @NotNull Writer writer) throws IOException {
        io.sentry.util.w.c(t10, "The entity is required.");
        io.sentry.util.w.c(writer, "The Writer object is required.");
        w0 logger = this.f27886a.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        if (logger.d(sentryLevel)) {
            this.f27886a.getLogger().c(sentryLevel, "Serializing object: %s", h(t10, this.f27886a.isEnablePrettySerializationOutput()));
        }
        new f2(writer, this.f27886a.getMaxDepth()).o(this.f27886a.getLogger(), t10);
        writer.flush();
    }

    @Override // io.sentry.l1
    public void b(@NotNull p5 p5Var, @NotNull OutputStream outputStream) throws Exception {
        io.sentry.util.w.c(p5Var, "The SentryEnvelope object is required.");
        io.sentry.util.w.c(outputStream, "The Stream object is required.");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), f27885c));
        try {
            p5Var.b().serialize(new f2(bufferedWriter, this.f27886a.getMaxDepth()), this.f27886a.getLogger());
            bufferedWriter.write("\n");
            for (p6 p6Var : p5Var.c()) {
                try {
                    byte[] bArrI = p6Var.I();
                    p6Var.K().serialize(new f2(bufferedWriter, this.f27886a.getMaxDepth()), this.f27886a.getLogger());
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
                    outputStream.write(bArrI);
                    bufferedWriter.write("\n");
                } catch (Exception e10) {
                    this.f27886a.getLogger().b(SentryLevel.ERROR, "Failed to create envelope item. Dropping it.", e10);
                }
            }
        } finally {
            bufferedWriter.flush();
        }
    }

    @Override // io.sentry.l1
    @Nullable
    public <T> T c(@NotNull Reader reader, @NotNull Class<T> cls) {
        try {
            d2 d2Var = new d2(reader);
            try {
                x1<?> x1Var = this.f27887b.get(cls);
                if (x1Var != null) {
                    T tCast = cls.cast(x1Var.deserialize(d2Var, this.f27886a.getLogger()));
                    d2Var.close();
                    return tCast;
                }
                if (!g(cls)) {
                    d2Var.close();
                    return null;
                }
                T t10 = (T) d2Var.A0();
                d2Var.close();
                return t10;
            } finally {
            }
        } catch (Exception e10) {
            this.f27886a.getLogger().b(SentryLevel.ERROR, "Error when deserializing", e10);
            return null;
        }
    }

    @Override // io.sentry.l1
    @Nullable
    public p5 d(@NotNull InputStream inputStream) {
        io.sentry.util.w.c(inputStream, "The InputStream object is required.");
        try {
            return this.f27886a.getEnvelopeReader().a(inputStream);
        } catch (IOException e10) {
            this.f27886a.getLogger().b(SentryLevel.ERROR, "Error deserializing envelope.", e10);
            return null;
        }
    }

    @Override // io.sentry.l1
    @Nullable
    public <T, R> T e(@NotNull Reader reader, @NotNull Class<T> cls, @Nullable x1<R> x1Var) {
        try {
            d2 d2Var = new d2(reader);
            try {
                if (!Collection.class.isAssignableFrom(cls)) {
                    T t10 = (T) d2Var.A0();
                    d2Var.close();
                    return t10;
                }
                if (x1Var == null) {
                    T t11 = (T) d2Var.A0();
                    d2Var.close();
                    return t11;
                }
                T t12 = (T) d2Var.D0(this.f27886a.getLogger(), x1Var);
                d2Var.close();
                return t12;
            } finally {
            }
        } catch (Throwable th) {
            this.f27886a.getLogger().b(SentryLevel.ERROR, "Error when deserializing", th);
            return null;
        }
    }

    @Override // io.sentry.l1
    @NotNull
    public String f(@NotNull Map<String, Object> map) throws Exception {
        return h(map, false);
    }
}
