/**
 */
package org.eclipse.viatra.cep.notification.test.model.carmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.viatra.cep.notification.test.model.carmodel.Car;
import org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelPackage;
import org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wheel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.WheelImpl#getCar <em>Car</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WheelImpl extends MinimalEObjectImpl.Container implements Wheel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WheelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CarmodelPackage.Literals.WHEEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Car getCar() {
		if (eContainerFeatureID() != CarmodelPackage.WHEEL__CAR) return null;
		return (Car)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCar(Car newCar, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCar, CarmodelPackage.WHEEL__CAR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCar(Car newCar) {
		if (newCar != eInternalContainer() || (eContainerFeatureID() != CarmodelPackage.WHEEL__CAR && newCar != null)) {
			if (EcoreUtil.isAncestor(this, newCar))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCar != null)
				msgs = ((InternalEObject)newCar).eInverseAdd(this, CarmodelPackage.CAR__WHEELS, Car.class, msgs);
			msgs = basicSetCar(newCar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarmodelPackage.WHEEL__CAR, newCar, newCar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CarmodelPackage.WHEEL__CAR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCar((Car)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CarmodelPackage.WHEEL__CAR:
				return basicSetCar(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CarmodelPackage.WHEEL__CAR:
				return eInternalContainer().eInverseRemove(this, CarmodelPackage.CAR__WHEELS, Car.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CarmodelPackage.WHEEL__CAR:
				return getCar();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CarmodelPackage.WHEEL__CAR:
				setCar((Car)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CarmodelPackage.WHEEL__CAR:
				setCar((Car)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CarmodelPackage.WHEEL__CAR:
				return getCar() != null;
		}
		return super.eIsSet(featureID);
	}

} //WheelImpl
