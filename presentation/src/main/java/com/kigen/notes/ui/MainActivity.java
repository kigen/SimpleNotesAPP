package com.kigen.notes.ui;


import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.kigen.notes.App;
import com.kigen.notes.R;
import com.kigen.notes.models.Note;
import com.kigen.notes.ui.adapter.NotesRecyclerAdapter;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity{

  @BindView(R.id.notesListView) RecyclerView notesListView;

  @BindView(R.id.toolbar) Toolbar toolbar;

  @Inject
  NotesListViewModel viewModel;

  NotesRecyclerAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    //setActionBar(toolbar);
    ((App)getApplication()).getApplicationComponent().inject(this);

    viewModel.getNotes().observe(this, new Observer<List<Note>>() {
      @Override public void onChanged(@Nullable List<Note> notes) {
          loadData(notes);
      }
    });

  }

  void loadData(List<Note> notes){
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    notesListView.setLayoutManager(layoutManager);
    adapter= new NotesRecyclerAdapter(getApplicationContext(),viewModel.getNotes().getValue());
    notesListView.setAdapter(adapter);
  }



  @OnClick(R.id.fab)
  void launchAddNote(){
    startActivity(new Intent(getApplicationContext(),AddNoteActivity.class));
  }

}
