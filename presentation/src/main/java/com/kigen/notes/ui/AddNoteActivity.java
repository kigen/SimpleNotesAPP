package com.kigen.notes.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.kigen.notes.App;
import com.kigen.notes.R;
import com.kigen.notes.models.Note;
import java.util.Date;
import javax.inject.Inject;

public class AddNoteActivity extends Activity {


  @BindView(R.id.titleView) EditText titleView;
  @BindView(R.id.contentView) EditText contentView;


  @Inject
  AddNoteViewModel viewModel;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_note);
    ButterKnife.bind(this);
    //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    ((App)getApplication()).getApplicationComponent().inject(this);
  }

  @OnClick(R.id.fab)
  void addNote(){
    final Note note = new Note();
    note.setContent(contentView.getText().toString());
    note.setTitle(titleView.getText().toString());
    note.setTime(new Date());
    viewModel.addNote(note);
    finish();
  }
}
