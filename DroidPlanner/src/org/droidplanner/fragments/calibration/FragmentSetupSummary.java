package org.droidplanner.fragments.calibration;

import org.droidplanner.fragments.SetupRadioFragment;
import org.droidplanner.fragments.calibration.SetupSidePanel;

import org.droidplanner.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentSetupSummary extends SetupSidePanel {

	public final static String EXTRA_TEXT_SUMMARY = FragmentSetupSummary.class
			.getName() + "" + ".extra.TEXT_SUMMARY";
	private int descId;
	private int titleId;
	private TextView textTitle;
	private TextView textDesc;
	private TextView textSummary;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final SetupRadioFragment setupFragment = (SetupRadioFragment) getParentFragment();

		final View view = inflater.inflate(
				R.layout.fragment_setup_panel_summary, container, false);

		textTitle = (TextView)view.findViewById(R.id.setupTitle);
		textDesc = (TextView)view.findViewById(R.id.setupDesc);
		textSummary = (TextView)view.findViewById(R.id.setupSummary);
		
		if(titleId!=0)
			textTitle.setText(titleId);
		
		if(descId!=0)
			textDesc.setText(descId);
		

		final Bundle args = getArguments();
		if (args != null) {
			textSummary.setText(args.getString(EXTRA_TEXT_SUMMARY, ""));
		}

		final Button btnSend = (Button) view.findViewById(R.id.buttonSend);
		btnSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (setupFragment != null) {
					setupFragment.doCalibrationStep(3);
				}
			}
		});

		final Button btnCancel = (Button) view.findViewById(R.id.buttonCancel);
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (setupFragment != null) {
					setupFragment.doCalibrationStep(-1);
				}
			}
		});
		return view;
	}

	@Override
	public void updateDescription(int idDescription) {
		this.descId = idDescription;
		
		if(textDesc!=null)
			textDesc.setText((descId));
				
	}

	@Override
	public void updateTitle(int idTitle) {
		this.titleId = idTitle;
		
		if(textTitle!=null)
			textTitle.setText(titleId);
	}
	
	public void updateSummary(String summary){
		if(textSummary!=null)
			textSummary.setText(summary);
	}
}
