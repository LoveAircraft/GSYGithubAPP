package com.gsygithubapp.views.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Created by guoshuyu on 2017/12/5.
 */
public class TopShouldStartLoadWithRequest extends Event<TopLoadingErrorEvent> {

    public static final String EVENT_NAME = "topShouldStartLoadWithRequest";
    private WritableMap mEventData;

    public TopShouldStartLoadWithRequest(int viewId, WritableMap eventData) {
        super(viewId);
        mEventData = eventData;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public boolean canCoalesce() {
        return false;
    }

    @Override
    public short getCoalescingKey() {
        // All events for a given view can be coalesced.
        return 0;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), mEventData);
    }
}