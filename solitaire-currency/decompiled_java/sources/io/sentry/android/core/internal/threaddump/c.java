package io.sentry.android.core.internal.threaddump;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.c7;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.s7;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ThreadDumpParser.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f27274f = Pattern.compile("\"(.*)\" (.*) ?prio=(\\d+)\\s+tid=(\\d+)\\s*(.*)");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f27275g = Pattern.compile("\"(.*)\" (.*) ?sysTid=(\\d+)");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f27276h = Pattern.compile(" *(?:native: )?#(\\d+) \\S+ ([0-9a-fA-F]+)\\s+((.*?)(?:\\s+\\(deleted\\))?(?:\\s+\\(offset (.*?)\\))?)(?:\\s+\\((?:\\?\\?\\?|(.*?)(?:\\+(\\d+))?)\\))?(?:\\s+\\(BuildId: (.*?)\\))?");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f27277i = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\((.*):([\\d-]+)\\)");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f27278j = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\(Native method\\)");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f27279k = Pattern.compile(" *- locked \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f27280l = Pattern.compile(" *- sleeping on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f27281m = Pattern.compile(" *- waiting on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f27282n = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Pattern f27283o = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)(?: held by thread (\\d+))");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Pattern f27284p = Pattern.compile(" *- waiting to lock an unknown object");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f27285q = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f27287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final s7 f27288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<String, DebugImage> f27289d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<SentryThread> f27290e = new ArrayList();

    public c(@NotNull SentryOptions sentryOptions, boolean z10) {
        this.f27286a = sentryOptions;
        this.f27287b = z10;
        this.f27288c = new s7(sentryOptions);
    }

    @Nullable
    private static String a(@NotNull String str) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new BigInteger("10" + str, 16).toByteArray());
            byteBufferWrap.get();
            return String.format("%08x-%04x-%04x-%04x-%04x%08x", Integer.valueOf(byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN).getInt()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.order(ByteOrder.BIG_ENDIAN).getShort()), Short.valueOf(byteBufferWrap.getShort()), Integer.valueOf(byteBufferWrap.getInt()));
        } catch (NumberFormatException | BufferUnderflowException unused) {
            return null;
        }
    }

    private void b(@NotNull SentryThread sentryThread, @NotNull c7 c7Var) {
        Map<String, c7> heldLocks = sentryThread.getHeldLocks();
        if (heldLocks == null) {
            heldLocks = new HashMap<>();
        }
        c7 c7Var2 = heldLocks.get(c7Var.f());
        if (c7Var2 != null) {
            c7Var2.l(Math.max(c7Var2.g(), c7Var.g()));
        } else {
            heldLocks.put(c7Var.f(), new c7(c7Var));
        }
        sentryThread.setHeldLocks(heldLocks);
    }

    @Nullable
    private Integer d(@NotNull Matcher matcher, int i10, @Nullable Integer num) {
        String strGroup = matcher.group(i10);
        return (strGroup == null || strGroup.length() == 0) ? num : Integer.valueOf(Integer.parseInt(strGroup));
    }

    @Nullable
    private Long e(@NotNull Matcher matcher, int i10, @Nullable Long l10) {
        String strGroup = matcher.group(i10);
        return (strGroup == null || strGroup.length() == 0) ? l10 : Long.valueOf(Long.parseLong(strGroup));
    }

    @Nullable
    private Integer g(@NotNull Matcher matcher, int i10, @Nullable Integer num) {
        String strGroup = matcher.group(i10);
        if (strGroup == null || strGroup.length() == 0) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(Integer.parseInt(strGroup));
        return numValueOf.intValue() >= 0 ? numValueOf : num;
    }

    private boolean h(@NotNull Matcher matcher, @NotNull String str) {
        matcher.reset(str);
        return matcher.matches();
    }

    @NotNull
    private SentryStackTrace j(@NotNull b bVar, @NotNull SentryThread sentryThread) {
        Matcher matcher;
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = f27276h.matcher("");
        Matcher matcher3 = f27277i.matcher("");
        Matcher matcher4 = f27278j.matcher("");
        Matcher matcher5 = f27279k.matcher("");
        Matcher matcher6 = f27281m.matcher("");
        Matcher matcher7 = f27280l.matcher("");
        Matcher matcher8 = f27283o.matcher("");
        Matcher matcher9 = f27282n.matcher("");
        Matcher matcher10 = f27284p.matcher("");
        Matcher matcher11 = f27285q.matcher("");
        SentryStackFrame sentryStackFrame = null;
        while (true) {
            if (!bVar.a()) {
                break;
            }
            a aVarB = bVar.b();
            if (aVarB == null) {
                this.f27286a.getLogger().c(SentryLevel.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                break;
            }
            String str = aVarB.f27269b;
            Matcher matcher12 = matcher11;
            if (h(matcher3, str)) {
                sentryStackFrame = new SentryStackFrame();
                String str2 = String.format("%s.%s", matcher3.group(1), matcher3.group(2));
                sentryStackFrame.setModule(str2);
                sentryStackFrame.setFunction(matcher3.group(3));
                sentryStackFrame.setFilename(matcher3.group(4));
                sentryStackFrame.setLineno(g(matcher3, 5, null));
                sentryStackFrame.setInApp(this.f27288c.b(str2));
                arrayList.add(sentryStackFrame);
                matcher = matcher3;
            } else {
                if (h(matcher2, str)) {
                    SentryStackFrame sentryStackFrame2 = new SentryStackFrame();
                    sentryStackFrame2.setPackage(matcher2.group(3));
                    sentryStackFrame2.setFunction(matcher2.group(6));
                    sentryStackFrame2.setLineno(d(matcher2, 7, null));
                    sentryStackFrame2.setInstructionAddr("0x" + matcher2.group(2));
                    sentryStackFrame2.setPlatform("native");
                    String strGroup = matcher2.group(8);
                    String strA = strGroup == null ? null : a(strGroup);
                    if (strA != null) {
                        if (this.f27289d.containsKey(strA)) {
                            matcher = matcher3;
                        } else {
                            DebugImage debugImage = new DebugImage();
                            debugImage.setDebugId(strA);
                            matcher = matcher3;
                            debugImage.setType("elf");
                            debugImage.setCodeFile(matcher2.group(4));
                            debugImage.setCodeId(strGroup);
                            this.f27289d.put(strA, debugImage);
                        }
                        sentryStackFrame2.setAddrMode("rel:" + strA);
                    } else {
                        matcher = matcher3;
                    }
                    arrayList.add(sentryStackFrame2);
                    matcher11 = matcher12;
                    sentryStackFrame = null;
                } else {
                    matcher = matcher3;
                    if (h(matcher4, str)) {
                        sentryStackFrame = new SentryStackFrame();
                        String str3 = String.format("%s.%s", matcher4.group(1), matcher4.group(2));
                        sentryStackFrame.setModule(str3);
                        sentryStackFrame.setFunction(matcher4.group(3));
                        sentryStackFrame.setInApp(this.f27288c.b(str3));
                        sentryStackFrame.setNative(Boolean.TRUE);
                        arrayList.add(sentryStackFrame);
                    } else if (h(matcher5, str)) {
                        if (sentryStackFrame != null) {
                            c7 c7Var = new c7();
                            c7Var.l(1);
                            c7Var.h(matcher5.group(1));
                            c7Var.j(matcher5.group(2));
                            c7Var.i(matcher5.group(3));
                            sentryStackFrame.setLock(c7Var);
                            b(sentryThread, c7Var);
                        }
                    } else if (h(matcher6, str)) {
                        if (sentryStackFrame != null) {
                            c7 c7Var2 = new c7();
                            c7Var2.l(2);
                            c7Var2.h(matcher6.group(1));
                            c7Var2.j(matcher6.group(2));
                            c7Var2.i(matcher6.group(3));
                            sentryStackFrame.setLock(c7Var2);
                            b(sentryThread, c7Var2);
                        }
                    } else if (!h(matcher7, str)) {
                        if (!h(matcher8, str)) {
                            if (!h(matcher9, str)) {
                                if (!h(matcher10, str)) {
                                    if (str.length() == 0) {
                                        break;
                                    }
                                    matcher11 = matcher12;
                                    if (h(matcher11, str)) {
                                        break;
                                    }
                                } else if (sentryStackFrame != null) {
                                    c7 c7Var3 = new c7();
                                    c7Var3.l(8);
                                    sentryStackFrame.setLock(c7Var3);
                                    b(sentryThread, c7Var3);
                                }
                            } else if (sentryStackFrame != null) {
                                c7 c7Var4 = new c7();
                                c7Var4.l(8);
                                c7Var4.h(matcher9.group(1));
                                c7Var4.j(matcher9.group(2));
                                c7Var4.i(matcher9.group(3));
                                sentryStackFrame.setLock(c7Var4);
                                b(sentryThread, c7Var4);
                            }
                        } else if (sentryStackFrame != null) {
                            c7 c7Var5 = new c7();
                            c7Var5.l(8);
                            c7Var5.h(matcher8.group(1));
                            c7Var5.j(matcher8.group(2));
                            c7Var5.i(matcher8.group(3));
                            c7Var5.k(e(matcher8, 4, null));
                            sentryStackFrame.setLock(c7Var5);
                            b(sentryThread, c7Var5);
                        }
                        matcher11 = matcher12;
                    } else if (sentryStackFrame != null) {
                        c7 c7Var6 = new c7();
                        c7Var6.l(4);
                        c7Var6.h(matcher7.group(1));
                        c7Var6.j(matcher7.group(2));
                        c7Var6.i(matcher7.group(3));
                        sentryStackFrame.setLock(c7Var6);
                        b(sentryThread, c7Var6);
                    }
                }
                matcher3 = matcher;
            }
            matcher11 = matcher12;
            matcher3 = matcher;
        }
        Collections.reverse(arrayList);
        SentryStackTrace sentryStackTrace = new SentryStackTrace(arrayList);
        sentryStackTrace.setSnapshot(Boolean.TRUE);
        return sentryStackTrace;
    }

    private SentryThread k(@NotNull b bVar) {
        SentryThread sentryThread = new SentryThread();
        Matcher matcher = f27274f.matcher("");
        Matcher matcher2 = f27275g.matcher("");
        if (!bVar.a()) {
            return null;
        }
        a aVarB = bVar.b();
        boolean z10 = false;
        if (aVarB == null) {
            this.f27286a.getLogger().c(SentryLevel.WARNING, "Internal error while parsing thread dump.", new Object[0]);
            return null;
        }
        if (h(matcher, aVarB.f27269b)) {
            Long lE = e(matcher, 4, null);
            if (lE == null) {
                this.f27286a.getLogger().c(SentryLevel.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            sentryThread.setId(lE);
            sentryThread.setName(matcher.group(1));
            String strGroup = matcher.group(5);
            if (strGroup != null) {
                if (strGroup.contains(" ")) {
                    sentryThread.setState(strGroup.substring(0, strGroup.indexOf(32)));
                } else {
                    sentryThread.setState(strGroup);
                }
            }
        } else if (h(matcher2, aVarB.f27269b)) {
            Long lE2 = e(matcher2, 3, null);
            if (lE2 == null) {
                this.f27286a.getLogger().c(SentryLevel.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            sentryThread.setId(lE2);
            sentryThread.setName(matcher2.group(1));
        }
        String name = sentryThread.getName();
        if (name != null) {
            boolean zEquals = name.equals("main");
            sentryThread.setMain(Boolean.valueOf(zEquals));
            sentryThread.setCrashed(Boolean.valueOf(zEquals));
            if (zEquals && !this.f27287b) {
                z10 = true;
            }
            sentryThread.setCurrent(Boolean.valueOf(z10));
        }
        sentryThread.setStacktrace(j(bVar, sentryThread));
        return sentryThread;
    }

    @NotNull
    public List<DebugImage> c() {
        return new ArrayList(this.f27289d.values());
    }

    @NotNull
    public List<SentryThread> f() {
        return this.f27290e;
    }

    public void i(@NotNull b bVar) {
        Matcher matcher = f27274f.matcher("");
        Matcher matcher2 = f27275g.matcher("");
        while (bVar.a()) {
            a aVarB = bVar.b();
            if (aVarB == null) {
                this.f27286a.getLogger().c(SentryLevel.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                return;
            }
            String str = aVarB.f27269b;
            if (h(matcher, str) || h(matcher2, str)) {
                bVar.d();
                SentryThread sentryThreadK = k(bVar);
                if (sentryThreadK != null) {
                    this.f27290e.add(sentryThreadK);
                }
            }
        }
    }
}
