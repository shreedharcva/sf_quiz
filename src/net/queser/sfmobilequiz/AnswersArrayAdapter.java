package net.queser.sfmobilequiz;

import java.util.ArrayList;
import java.util.List;

import net.queser.sfmobilequiz.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;



public class AnswersArrayAdapter extends ArrayAdapter<String> {
	private final Context CurContext;
	private final String[] Values;
	public static List<Integer> selectedOptions;
 
	public AnswersArrayAdapter(Context context, int itemLayoutId, String[] values) {
		super(context, itemLayoutId, values);
		this.CurContext = context;
		this.Values = values;
		if(AnswersArrayAdapter.selectedOptions != null && AnswersArrayAdapter.selectedOptions.size() > 0) {
			AnswersArrayAdapter.selectedOptions.clear();
		} else {
			AnswersArrayAdapter.selectedOptions = new ArrayList<Integer>();
		}
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) CurContext
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.option, parent, false);
		final int index = position;
		final CheckBox cboxView = (CheckBox) rowView.findViewById(R.id.optionCheckbox);
		cboxView.setText(Integer.toString(position+1) + ". " + Values[position]);
		cboxView.setOnClickListener(new OnClickListener() {   
	        @Override
	        public void onClick(View v) {
	        	
	            if (cboxView.isChecked() && !selectedOptions.contains(index)) {
	            	selectedOptions.add(index);
	            	Toast.makeText(CurContext,cboxView.getText(), Toast.LENGTH_SHORT).show();
	            } else if (!cboxView.isChecked() && selectedOptions.contains(index)) {
	            	selectedOptions.remove(index);
	            	
	            }
	        }
	   });

		return rowView;
	}
}
