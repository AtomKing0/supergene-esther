package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewHierarchyNode implements h2 {

    @Nullable
    private Double alpha;

    @Nullable
    private List<ViewHierarchyNode> children;

    @Nullable
    private Double height;

    @Nullable
    private String identifier;

    @Nullable
    private String renderingSystem;

    @Nullable
    private String tag;

    @Nullable
    private String type;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String visibility;

    @Nullable
    private Double width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private Double f28074x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private Double f28075y;

    public static final class Deserializer implements x1<ViewHierarchyNode> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public ViewHierarchyNode deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            ViewHierarchyNode viewHierarchyNode = new ViewHierarchyNode();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "rendering_system":
                        viewHierarchyNode.renderingSystem = l3Var.o0();
                        break;
                    case "identifier":
                        viewHierarchyNode.identifier = l3Var.o0();
                        break;
                    case "height":
                        viewHierarchyNode.height = l3Var.A();
                        break;
                    case "x":
                        viewHierarchyNode.f28074x = l3Var.A();
                        break;
                    case "y":
                        viewHierarchyNode.f28075y = l3Var.A();
                        break;
                    case "tag":
                        viewHierarchyNode.tag = l3Var.o0();
                        break;
                    case "type":
                        viewHierarchyNode.type = l3Var.o0();
                        break;
                    case "alpha":
                        viewHierarchyNode.alpha = l3Var.A();
                        break;
                    case "width":
                        viewHierarchyNode.width = l3Var.A();
                        break;
                    case "children":
                        viewHierarchyNode.children = l3Var.D0(w0Var, this);
                        break;
                    case "visibility":
                        viewHierarchyNode.visibility = l3Var.o0();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        l3Var.r0(w0Var, map, strC);
                        break;
                }
            }
            l3Var.k();
            viewHierarchyNode.setUnknown(map);
            return viewHierarchyNode;
        }
    }

    public static final class JsonKeys {
        public static final String ALPHA = "alpha";
        public static final String CHILDREN = "children";
        public static final String HEIGHT = "height";
        public static final String IDENTIFIER = "identifier";
        public static final String RENDERING_SYSTEM = "rendering_system";
        public static final String TAG = "tag";
        public static final String TYPE = "type";
        public static final String VISIBILITY = "visibility";
        public static final String WIDTH = "width";
        public static final String X = "x";
        public static final String Y = "y";
    }

    @Nullable
    public Double getAlpha() {
        return this.alpha;
    }

    @Nullable
    public List<ViewHierarchyNode> getChildren() {
        return this.children;
    }

    @Nullable
    public Double getHeight() {
        return this.height;
    }

    @Nullable
    public String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public String getRenderingSystem() {
        return this.renderingSystem;
    }

    @Nullable
    public String getTag() {
        return this.tag;
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getVisibility() {
        return this.visibility;
    }

    @Nullable
    public Double getWidth() {
        return this.width;
    }

    @Nullable
    public Double getX() {
        return this.f28074x;
    }

    @Nullable
    public Double getY() {
        return this.f28075y;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.renderingSystem != null) {
            m3Var.e("rendering_system").g(this.renderingSystem);
        }
        if (this.type != null) {
            m3Var.e("type").g(this.type);
        }
        if (this.identifier != null) {
            m3Var.e(JsonKeys.IDENTIFIER).g(this.identifier);
        }
        if (this.tag != null) {
            m3Var.e(JsonKeys.TAG).g(this.tag);
        }
        if (this.width != null) {
            m3Var.e("width").n(this.width);
        }
        if (this.height != null) {
            m3Var.e("height").n(this.height);
        }
        if (this.f28074x != null) {
            m3Var.e(JsonKeys.X).n(this.f28074x);
        }
        if (this.f28075y != null) {
            m3Var.e(JsonKeys.Y).n(this.f28075y);
        }
        if (this.visibility != null) {
            m3Var.e("visibility").g(this.visibility);
        }
        if (this.alpha != null) {
            m3Var.e("alpha").n(this.alpha);
        }
        List<ViewHierarchyNode> list = this.children;
        if (list != null && !list.isEmpty()) {
            m3Var.e(JsonKeys.CHILDREN).o(w0Var, this.children);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setAlpha(@Nullable Double d10) {
        this.alpha = d10;
    }

    public void setChildren(@Nullable List<ViewHierarchyNode> list) {
        this.children = list;
    }

    public void setHeight(@Nullable Double d10) {
        this.height = d10;
    }

    public void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    public void setRenderingSystem(String str) {
        this.renderingSystem = str;
    }

    public void setTag(@Nullable String str) {
        this.tag = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVisibility(@Nullable String str) {
        this.visibility = str;
    }

    public void setWidth(@Nullable Double d10) {
        this.width = d10;
    }

    public void setX(@Nullable Double d10) {
        this.f28074x = d10;
    }

    public void setY(@Nullable Double d10) {
        this.f28075y = d10;
    }
}
