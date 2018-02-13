package com.kigen.notes.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.kigen.notes.R;
import com.kigen.notes.models.Note;
import java.util.List;

/**
 * Author: kigen
 * Date: 25/09/2017.
 */

public class NotesRecyclerAdapter extends BaseRecyclerAdapter<Note,NotesRecyclerAdapter.ViewHolder> {

  public NotesRecyclerAdapter(Context context, List<Note> notes){
    super(context,notes);
  }


  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_note_list_item, parent, false);

    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Note note = getItem(position);
    holder.noteSummaryView.setText(note.getTitle());
    holder.noteTitleView.setText(note.getTitle());
    holder.dateView .setText(note.getTime().toString());
    holder.authorNameView.setText(note.getAuthor());
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvNoteTitle)  TextView noteTitleView;
    @BindView(R.id.tvNoteContent)  TextView noteSummaryView;
    @BindView(R.id.tvDate) TextView dateView;
    @BindView(R.id.tvAuthorName) TextView authorNameView;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(itemView);
    }
  }
}
