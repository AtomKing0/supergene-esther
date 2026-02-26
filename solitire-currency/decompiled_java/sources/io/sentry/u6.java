package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SentryFeedbackOptions.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class u6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f28318a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f28319b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28320c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f28321d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28322e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f28323f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private CharSequence f28324g = "Report a Bug";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private CharSequence f28325h = "Send Bug Report";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private CharSequence f28326i = "Cancel";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private CharSequence f28327j = "Name";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private CharSequence f28328k = "Your Name";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private CharSequence f28329l = "Email";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private CharSequence f28330m = "your.email@example.org";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private CharSequence f28331n = " (Required)";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private CharSequence f28332o = "Description";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private CharSequence f28333p = "What's the bug? What did you expect?";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private CharSequence f28334q = "Thank you for your report!";

    public boolean a() {
        return this.f28320c;
    }

    public boolean b() {
        return this.f28318a;
    }

    public boolean c() {
        return this.f28323f;
    }

    public boolean d() {
        return this.f28321d;
    }

    public boolean e() {
        return this.f28319b;
    }

    public boolean f() {
        return this.f28322e;
    }

    public void g(boolean z10) {
        this.f28320c = z10;
    }

    public void h(boolean z10) {
        this.f28318a = z10;
    }

    public void i(boolean z10) {
        this.f28323f = z10;
    }

    public void j(boolean z10) {
        this.f28321d = z10;
    }

    public void k(boolean z10) {
        this.f28319b = z10;
    }

    public void l(boolean z10) {
        this.f28322e = z10;
    }

    public String toString() {
        return "SentryFeedbackOptions{isNameRequired=" + this.f28318a + ", showName=" + this.f28319b + ", isEmailRequired=" + this.f28320c + ", showEmail=" + this.f28321d + ", useSentryUser=" + this.f28322e + ", showBranding=" + this.f28323f + ", formTitle='" + ((Object) this.f28324g) + "', submitButtonLabel='" + ((Object) this.f28325h) + "', cancelButtonLabel='" + ((Object) this.f28326i) + "', nameLabel='" + ((Object) this.f28327j) + "', namePlaceholder='" + ((Object) this.f28328k) + "', emailLabel='" + ((Object) this.f28329l) + "', emailPlaceholder='" + ((Object) this.f28330m) + "', isRequiredLabel='" + ((Object) this.f28331n) + "', messageLabel='" + ((Object) this.f28332o) + "', messagePlaceholder='" + ((Object) this.f28333p) + "'}";
    }
}
