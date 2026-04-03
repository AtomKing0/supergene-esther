package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewHierarchy implements h2 {

    @Nullable
    private final String renderingSystem;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private final List<ViewHierarchyNode> windows;

    public static final class Deserializer implements x1<ViewHierarchy> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public ViewHierarchy deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            String strO0 = null;
            List listD0 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("rendering_system")) {
                    strO0 = l3Var.o0();
                } else if (strC.equals(JsonKeys.WINDOWS)) {
                    listD0 = l3Var.D0(w0Var, new ViewHierarchyNode.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            l3Var.k();
            ViewHierarchy viewHierarchy = new ViewHierarchy(strO0, listD0);
            viewHierarchy.setUnknown(map);
            return viewHierarchy;
        }
    }

    public static final class JsonKeys {
        public static final String RENDERING_SYSTEM = "rendering_system";
        public static final String WINDOWS = "windows";
    }

    public ViewHierarchy(@Nullable String str, @Nullable List<ViewHierarchyNode> list) {
        this.renderingSystem = str;
        this.windows = list;
    }

    @Nullable
    public String getRenderingSystem() {
        return this.renderingSystem;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public List<ViewHierarchyNode> getWindows() {
        return this.windows;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.renderingSystem != null) {
            m3Var.e("rendering_system").g(this.renderingSystem);
        }
        if (this.windows != null) {
            m3Var.e(JsonKeys.WINDOWS).o(w0Var, this.windows);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
