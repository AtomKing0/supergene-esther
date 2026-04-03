package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.webkit.UserAgentMetadata;
import androidx.webkit.WebViewMediaIntegrityApiStatusConfig;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: loaded from: classes2.dex */
public class WebSettingsAdapter {
    private final WebSettingsBoundaryInterface mBoundaryInterface;

    public WebSettingsAdapter(@NonNull WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.mBoundaryInterface = webSettingsBoundaryInterface;
    }

    public int getAttributionRegistrationBehavior() {
        return this.mBoundaryInterface.getAttributionBehavior();
    }

    public int getDisabledActionModeMenuItems() {
        return this.mBoundaryInterface.getDisabledActionModeMenuItems();
    }

    public boolean getEnterpriseAuthenticationAppLinkPolicyEnabled() {
        return this.mBoundaryInterface.getEnterpriseAuthenticationAppLinkPolicyEnabled();
    }

    public int getForceDark() {
        return this.mBoundaryInterface.getForceDark();
    }

    public int getForceDarkStrategy() {
        return this.mBoundaryInterface.getForceDarkBehavior();
    }

    public boolean getOffscreenPreRaster() {
        return this.mBoundaryInterface.getOffscreenPreRaster();
    }

    @NonNull
    public Set<String> getRequestedWithHeaderOriginAllowList() {
        return this.mBoundaryInterface.getRequestedWithHeaderOriginAllowList();
    }

    public boolean getSafeBrowsingEnabled() {
        return this.mBoundaryInterface.getSafeBrowsingEnabled();
    }

    @NonNull
    public UserAgentMetadata getUserAgentMetadata() {
        return UserAgentMetadataInternal.getUserAgentMetadataFromMap(this.mBoundaryInterface.getUserAgentMetadataMap());
    }

    @NonNull
    public WebViewMediaIntegrityApiStatusConfig getWebViewMediaIntegrityApiStatus() {
        return new WebViewMediaIntegrityApiStatusConfig.Builder(this.mBoundaryInterface.getWebViewMediaIntegrityApiDefaultStatus()).setOverrideRules(this.mBoundaryInterface.getWebViewMediaIntegrityApiOverrideRules()).build();
    }

    public boolean isAlgorithmicDarkeningAllowed() {
        return this.mBoundaryInterface.isAlgorithmicDarkeningAllowed();
    }

    public void setAlgorithmicDarkeningAllowed(boolean z10) {
        this.mBoundaryInterface.setAlgorithmicDarkeningAllowed(z10);
    }

    public void setAttributionRegistrationBehavior(int i10) {
        this.mBoundaryInterface.setAttributionBehavior(i10);
    }

    public void setDisabledActionModeMenuItems(int i10) {
        this.mBoundaryInterface.setDisabledActionModeMenuItems(i10);
    }

    public void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean z10) {
        this.mBoundaryInterface.setEnterpriseAuthenticationAppLinkPolicyEnabled(z10);
    }

    public void setForceDark(int i10) {
        this.mBoundaryInterface.setForceDark(i10);
    }

    public void setForceDarkStrategy(int i10) {
        this.mBoundaryInterface.setForceDarkBehavior(i10);
    }

    public void setOffscreenPreRaster(boolean z10) {
        this.mBoundaryInterface.setOffscreenPreRaster(z10);
    }

    public void setRequestedWithHeaderOriginAllowList(@NonNull Set<String> set) {
        this.mBoundaryInterface.setRequestedWithHeaderOriginAllowList(set);
    }

    public void setSafeBrowsingEnabled(boolean z10) {
        this.mBoundaryInterface.setSafeBrowsingEnabled(z10);
    }

    public void setUserAgentMetadata(@NonNull UserAgentMetadata userAgentMetadata) {
        this.mBoundaryInterface.setUserAgentMetadataFromMap(UserAgentMetadataInternal.convertUserAgentMetadataToMap(userAgentMetadata));
    }

    public void setWebViewMediaIntegrityApiStatus(@NonNull WebViewMediaIntegrityApiStatusConfig webViewMediaIntegrityApiStatusConfig) {
        this.mBoundaryInterface.setWebViewMediaIntegrityApiStatus(webViewMediaIntegrityApiStatusConfig.getDefaultStatus(), webViewMediaIntegrityApiStatusConfig.getOverrideRules());
    }
}
