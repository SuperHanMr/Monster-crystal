package com.itheima.monstercrystal.fragment;

import android.content.Context;

import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imkit.widget.adapter.MessageListAdapter;

/**
 * Created by hanyonghui on 2017/6/20.
 */

public class MessageFragment extends ConversationFragment{

    public MessageListAdapter onResolveAdapter(Context context) {
        return new MessageListAdapter(context);
    }
}
