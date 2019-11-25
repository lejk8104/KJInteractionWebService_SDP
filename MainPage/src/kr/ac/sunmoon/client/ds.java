//////private void addButtons() {
//////		
////////		아이디 중복확인
////		Button btnIDCheck = new Button();
////		btnIDCheck.addClickHandler(new ClickHandler() {
////			
////			@Override
////			public void onClick(ClickEvent event) {
////				// TODO Auto-generated method stub
////				String[] checks = new String[1];
////				
////				if(txtinputs[0].getText().trim().equals("")) {
////					
////					Window.alert("Please Input your ID");
////					return;
////				}
////				KJMember kjMember = new KJMember();
////				kjMember.setID(txtinputs[0].getText().trim());
////				
////				KJMembershipServiceAsync checkservice = GWT.create(KJMembershipService.class);
////				checkservice.checkID(kjMember, new AsyncCallback<Boolean>() {
////
////					@Override
////					public void onFailure(Throwable caught) {
////						// TODO Auto-generated method stub
////						Window.alert("this ID already exists. ");
//////						Register_Membership.this.hide();
////					}
////					@Override
////					public void onSuccess(Boolean result) {
////						// TODO Auto-generated method stub
////						Window.alert("This ID is available");
////					}
////				});
////			}
////		});
////		btnIDCheck.setText("CheckID");
////		
//////		OK 버튼
////		Button btnOk = new Button();
////		btnOk.addClickHandler(new ClickHandler() {
////			
////			@Override
////			public void onClick(ClickEvent event) {
////				// TODO Auto-generated method stub
////				String[] membershipData = new String[4];
////				String [] listData = new String[4];
////				String[] interestData = new String[3];
////				String[] subinputdata = new String[3];
////				String male = "Male";
////				String female = "Female";				
////				String korean = "Korean";
////				String japanese = "Japanese";
////				
////				for(int i=0; i<membershipData.length; i++) {
////					membershipData[i] = txtinputs[i].getText().trim();
////					
////					if(membershipData[i].equals("")) {
////						Window.alert("Please, Input Your ALl Data");
////						return;
////					}
////					if(membershipData[1].equals(membershipData[2])) {
////						Window.alert("Please, check your password");
////						return;
////					}
////				}
////				
////				for(int i=0; i<listData.length; i++) {
////					int index =0;
////					if (listinputs[0].getItemText(index) == "0") {
////						listinputs[0].setItemText(0, male);
////					}
////					else if (listinputs[0].getItemText(index) == "1") {
////						listinputs[0].setItemText(1, female);
////					}
////					else if(listinputs[2].getItemText(index) == "0") {
////						listinputs[2].setItemText(0, korean);
////					}
////					else if(listinputs[2].getItemText(index) == "1") {
////						listinputs[2].setItemText(0, japanese);
////					}
////					else;
////					listinputs[i].getSelectedItemText().trim();
////					if(listData[i].equals("")) {
////						Window.alert("Please, Input Your Interest survey data");
////						return;
////						
//////					index= index+1;
////					}
////				}
////				for(int i=0; i<interestData.length; i++) {
////					interestData[i] =  interestinput[i].getText().trim();
////					
////					if(interestData[i].equals("")) {
////						Window.alert("Please, Input Your other survey datas");
////						return;
////					}
////				}
////				for(int i=0; i<subinputdata.length; i++) {
////					subinputdata[i]=Integer.toString(subinputs[i].getSelectedIndex()-2).trim();
////					if(subinputdata[i].equals("")) {
////						Window.alert("Please, Input Your other survey datas");
////						return;
////					}
////				}
////				//kjmembership_dataset
//				KJMember kjMember = new KJMember();
//				kjMember.setID(membershipData[0]);
//				kjMember.setPassword(membershipData[1]);
//				kjMember.setCheckPassword(membershipData[2]);
//				kjMember.setName(membershipData[3]);
////				kjMember.setGender(membershipData[4);
//				kjMember.setGender(listData[0]);
//				kjMember.setYear(listData[1]);
//				kjMember.setDate(listData[2]);
//				kjMember.setCountry(listData[3]);
//				kjMember.setLocal(listData[4]);
////				
////				//survey data set
////				Survey_data surveyData = new Survey_data();
////				surveyData.setID(membershipData[0]);
////				surveyData.setName(membershipData[3]);
////				surveyData.setPreference(subinputdata[0]);
//////				surveyData.setInterest(interestData);
////				surveyData.setA(subinputdata[1]);
////				surveyData.setB(subinputdata[2]);
////				surveyData.setC(subinputdata[3]);
//////				surveyData.setNumber(`);
////				
////				//Korean survey data Statistic
//////				surveyData.setGyeonggi_people(gyeonggi_people);
//////				surveyData.setSeoul_people(seoul_people);
//////				surveyData.setGangwon_people(gangwon_people);
//////				surveyData.setNorth_Chungcheong_people(north_Chungcheong_people);
//////				surveyData.setSouth_Chungcheong_people(south_Chungcheong_people);
//////				surveyData.setNorth_Gyeongsang_people(north_Gyeongsang_people);
//////				surveyData.setSouth_Gyeongsang_people(south_Gyeongsang_people);
//////				surveyData.setNorth_Jeolla_people(north_Jeolla_people);
//////				surveyData.setSouth_Jeolla_peoples(south_Jeolla_peoples);
////				
////				////Japanese survey data Statistic
//////				surveyData.setHokkaido_people(hokkaido_people);
//////				surveyData.setTohoku_people(tohoku_people);
//////				surveyData.setKanto_people(kanto_people);
//////				surveyData.setChubu_people(chubu_people);
//////				surveyData.setKinki_people(kinki_people);
//////				surveyData.setChugoku_people(chugoku_people);
//////				surveyData.setShikokupeople(shikokupeople);
////				
////				//서버통신
////				KJMembershipServiceAsync service = GWT.create(KJMembershipService.class);
////				service.Register_Membership(kjMember, new AsyncCallback<Void>() {
////					
////					@Override
////					public void onSuccess(Void result) {
////						// TODO Auto-generated method stub
////						Window.alert("Welcome to the membership");
////						Register_Membership.this.hide();
////						
////					}
////					@Override
////					public void onFailure(Throwable caught) {
////						// TODO Auto-generated method stub
////						Window.alert("Sorry, Please try agian after few minutes");
////						Register_Membership.this.hide();
////					}
////				});
////			}
////		});
////		btnOk.setText("Register");
////		
////		//취소
////		Button btnCancel = new Button();
////		btnCancel.setText("Cancel");
////		btnCancel.addClickHandler(new ClickHandler() {
////			@Override
////			public void onClick(ClickEvent arg0) {
////				// TODO Auto-generated method stub
////				Register_Membership.this.hide();
////			}
////		});
////	}