package com.example.kakacommunity.community;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kakacommunity.R;
import com.example.kakacommunity.home.HomeAdapter;
import com.example.kakacommunity.model.CommuityReply;

import java.util.ArrayList;
import java.util.List;

public class CommunityDetailAdapter extends RecyclerView.Adapter<CommunityDetailAdapter.ViewHolder> {

    private List<CommuityReply> communityReplyList = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView replyName;
        TextView replyTime;
        TextView replyContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.community_reply_author_image);
            replyName = (TextView)itemView.findViewById(R.id.community_reply_author);
            replyTime = (TextView)itemView.findViewById(R.id.community_reply_time);
            replyContent = (TextView)itemView.findViewById(R.id.community_reply_content);
        }
    }

    public CommunityDetailAdapter(List<CommuityReply> communityReplyList) {
        this.communityReplyList = communityReplyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commuity_reply_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommuityReply commuityReply = communityReplyList.get(position);
        holder.replyName.setText(commuityReply.getName());
        holder.replyTime.setText(commuityReply.getTime());
        holder.replyContent.setText(commuityReply.getContent());
    }

    @Override
    public int getItemCount() {
        return communityReplyList.size();
    }



    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemCLickListener(OnItemClickListener onItemCLickListener) {
        this.onItemClickListener = onItemCLickListener;
    }
}