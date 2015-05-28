package animations.JellyFish;

import MCACommonLibrary.animation.Channel;
import MCACommonLibrary.animation.KeyFrame;
import MCACommonLibrary.math.Quaternion;
import MCACommonLibrary.math.Vector3f;

public class ChannelFly extends Channel {
	public ChannelFly(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("Noga2", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Noga3", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Noga7", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Noga4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Noga6", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Noga8", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Noga5", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Noga1", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersTranslations.put("Noga2", new Vector3f(1.0F, -19.0F, 6.0F));
frame0.modelRenderersTranslations.put("Noga3", new Vector3f(1.0F, -19.0F, 0.0F));
frame0.modelRenderersTranslations.put("Noga7", new Vector3f(5.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("Noga4", new Vector3f(1.0F, -13.0F, 0.0F));
frame0.modelRenderersTranslations.put("Noga6", new Vector3f(5.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("Noga8", new Vector3f(5.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("Noga5", new Vector3f(5.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("Noga1", new Vector3f(1.0F, -13.0F, 6.0F));
keyFrames.put(0, frame0);

KeyFrame frame50 = new KeyFrame();
frame50.modelRenderersRotations.put("Noga2", new Quaternion(0.0F, -0.25881904F, 0.0F, 0.9659258F));
frame50.modelRenderersRotations.put("Noga3", new Quaternion(0.0F, 0.25881904F, 0.0F, 0.9659258F));
frame50.modelRenderersRotations.put("Noga7", new Quaternion(0.0F, -0.5F, 0.0F, 0.8660254F));
frame50.modelRenderersRotations.put("Noga4", new Quaternion(0.0F, 0.25881904F, 0.0F, 0.9659258F));
frame50.modelRenderersRotations.put("Noga6", new Quaternion(0.0F, -0.5F, 0.0F, 0.8660254F));
frame50.modelRenderersRotations.put("Noga8", new Quaternion(0.0F, 0.5F, 0.0F, 0.8660254F));
frame50.modelRenderersRotations.put("Noga5", new Quaternion(0.0F, 0.5F, 0.0F, 0.8660254F));
frame50.modelRenderersRotations.put("Noga1", new Quaternion(0.0F, -0.25881904F, 0.0F, 0.9659258F));
frame50.modelRenderersTranslations.put("Noga2", new Vector3f(1.0F, -19.0F, 6.0F));
frame50.modelRenderersTranslations.put("Noga3", new Vector3f(1.0F, -19.0F, 0.0F));
frame50.modelRenderersTranslations.put("Noga7", new Vector3f(5.0F, 0.0F, 0.0F));
frame50.modelRenderersTranslations.put("Noga4", new Vector3f(1.0F, -13.0F, 0.0F));
frame50.modelRenderersTranslations.put("Noga6", new Vector3f(5.0F, 0.0F, 0.0F));
frame50.modelRenderersTranslations.put("Noga8", new Vector3f(5.0F, 0.0F, 0.0F));
frame50.modelRenderersTranslations.put("Noga5", new Vector3f(5.0F, 0.0F, 0.0F));
frame50.modelRenderersTranslations.put("Noga1", new Vector3f(1.0F, -13.0F, 6.0F));
keyFrames.put(50, frame50);

KeyFrame frame99 = new KeyFrame();
frame99.modelRenderersRotations.put("Noga2", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersRotations.put("Noga3", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersRotations.put("Noga7", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersRotations.put("Noga4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersRotations.put("Noga6", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersRotations.put("Noga8", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersRotations.put("Noga5", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersRotations.put("Noga1", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame99.modelRenderersTranslations.put("Noga2", new Vector3f(1.0F, -19.0F, 6.0F));
frame99.modelRenderersTranslations.put("Noga3", new Vector3f(1.0F, -19.0F, 0.0F));
frame99.modelRenderersTranslations.put("Noga7", new Vector3f(5.0F, 0.0F, 0.0F));
frame99.modelRenderersTranslations.put("Noga4", new Vector3f(1.0F, -13.0F, 0.0F));
frame99.modelRenderersTranslations.put("Noga6", new Vector3f(5.0F, 0.0F, 0.0F));
frame99.modelRenderersTranslations.put("Noga8", new Vector3f(5.0F, 0.0F, 0.0F));
frame99.modelRenderersTranslations.put("Noga5", new Vector3f(5.0F, 0.0F, 0.0F));
frame99.modelRenderersTranslations.put("Noga1", new Vector3f(1.0F, -13.0F, 6.0F));
keyFrames.put(99, frame99);

}
}