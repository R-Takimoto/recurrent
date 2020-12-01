package model;

public class Energy {
	int ageId;
	int genderId;
	int levelId;
	int energyId;

	public Energy(int ageId,int genderId,int levelId,int energyId) {
		this.ageId=ageId;
		this.genderId=genderId;
		this.levelId=levelId;
		this.energyId=energyId;
	}
//	仮3つコンストラクタ
	public Energy(int ageId,int genderId,int levelId) {
		this.ageId=ageId;
		this.genderId=genderId;
		this.levelId=levelId;
	}

	public int getAgeId() {
		return ageId;
	}

	public int getGenderId() {
		return genderId;
	}

	public int getLevelId() {
		return levelId;
	}

	public int getEnergyId() {
		return energyId;
	}


}
