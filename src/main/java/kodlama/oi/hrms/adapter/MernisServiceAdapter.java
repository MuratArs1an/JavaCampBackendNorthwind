package kodlama.oi.hrms.adapter;

import java.rmi.RemoteException;

import kodlama.oi.hrms.business.abstracts.CandidateCheckService;
import kodlama.oi.hrms.entities.concretes.Candidates;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CandidateCheckService {

	@Override
	public boolean loginControl(Candidates candidates) {
		KPSPublicSoapProxy client= new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(candidates.getNationalId(),candidates.getName().toUpperCase(),candidates.getSurname().toUpperCase(),candidates.getBirthYear());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
