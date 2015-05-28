package animations.SmallOverPlant;

import java.util.HashMap;

import MCACommonLibrary.IMCAnimatedEntity;
import MCACommonLibrary.animation.AnimationHandler;
import MCACommonLibrary.animation.Channel;

public class AnimationHandlerSmallOverPlant extends AnimationHandler {
	/** Map with all the animations. */
	public static HashMap<String, Channel> animChannels = new HashMap<String, Channel>();
static
{
animChannels.put("RuchJezykow", new ChannelRuchJezykow("RuchJezykow", 30.0F, 150, Channel.LOOP));
}
	public AnimationHandlerSmallOverPlant(IMCAnimatedEntity entity) {
		super(entity);
	}

	@Override
	public void activateAnimation(String name, float startingFrame) {
		super.activateAnimation(animChannels, name, startingFrame);
	}

	@Override
	public void stopAnimation(String name) {
		super.stopAnimation(animChannels, name);
	}

	@Override
	public void fireAnimationEventClientSide(Channel anim, float prevFrame, float frame) {
	}

	@Override
	public void fireAnimationEventServerSide(Channel anim, float prevFrame, float frame) {
	}}