package animations.SmallOverPlant;

import MCACommonLibrary.animation.Channel;
import MCACommonLibrary.animation.KeyFrame;
import MCACommonLibrary.math.Quaternion;
import MCACommonLibrary.math.Vector3f;

public class ChannelRuchJezykow extends Channel {
	public ChannelRuchJezykow(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("Jezyk3", new Quaternion(0.0F, 0.0F, -0.9969173F, 0.078459084F));
frame0.modelRenderersRotations.put("Jezyk2", new Quaternion(-0.0784591F, 0.0F, 0.0F, 0.9969173F));
frame0.modelRenderersRotations.put("Jezyk1", new Quaternion(0.0F, 0.0F, -0.0784591F, 0.9969173F));
frame0.modelRenderersRotations.put("Jezyk4", new Quaternion(3.4295562E-9F, -0.9969173F, -0.0784591F, -4.357664E-8F));
frame0.modelRenderersTranslations.put("Jezyk3", new Vector3f(-2.0F, -21.0F, 4.0F));
frame0.modelRenderersTranslations.put("Jezyk2", new Vector3f(-2.0F, -20.0F, 0.0F));
frame0.modelRenderersTranslations.put("Jezyk1", new Vector3f(2.0F, -20.0F, 4.0F));
frame0.modelRenderersTranslations.put("Jezyk4", new Vector3f(2.0F, -20.0F, 4.0F));
keyFrames.put(0, frame0);

KeyFrame frame149 = new KeyFrame();
frame149.modelRenderersRotations.put("Jezyk2", new Quaternion(-0.0784591F, 0.0F, 0.0F, 0.9969173F));
frame149.modelRenderersRotations.put("Jezyk3", new Quaternion(0.0F, 0.0F, -0.9969173F, 0.078459084F));
frame149.modelRenderersRotations.put("Jezyk1", new Quaternion(0.0F, 0.0F, -0.0784591F, 0.9969173F));
frame149.modelRenderersRotations.put("Jezyk4", new Quaternion(3.4295562E-9F, -0.9969173F, -0.0784591F, -4.357664E-8F));
frame149.modelRenderersTranslations.put("Jezyk2", new Vector3f(-2.0F, -20.0F, 0.0F));
frame149.modelRenderersTranslations.put("Jezyk3", new Vector3f(-2.0F, -21.0F, 4.0F));
frame149.modelRenderersTranslations.put("Jezyk1", new Vector3f(2.0F, -20.0F, 4.0F));
frame149.modelRenderersTranslations.put("Jezyk4", new Vector3f(2.0F, -20.0F, 4.0F));
keyFrames.put(149, frame149);

KeyFrame frame75 = new KeyFrame();
frame75.modelRenderersRotations.put("Jezyk2", new Quaternion(0.0784591F, 0.0F, 0.0F, 0.9969173F));
frame75.modelRenderersRotations.put("Jezyk3", new Quaternion(0.0F, 0.0F, 0.9969173F, 0.078459084F));
frame75.modelRenderersRotations.put("Jezyk1", new Quaternion(0.0F, 0.0F, 0.0784591F, 0.9969173F));
frame75.modelRenderersRotations.put("Jezyk4", new Quaternion(-3.4295562E-9F, -0.9969173F, 0.0784591F, -4.357664E-8F));
frame75.modelRenderersTranslations.put("Jezyk2", new Vector3f(-2.0F, -20.0F, 0.0F));
frame75.modelRenderersTranslations.put("Jezyk3", new Vector3f(-2.0F, -21.0F, 4.0F));
frame75.modelRenderersTranslations.put("Jezyk1", new Vector3f(2.0F, -20.0F, 4.0F));
frame75.modelRenderersTranslations.put("Jezyk4", new Vector3f(2.0F, -20.0F, 4.0F));
keyFrames.put(75, frame75);

}
}