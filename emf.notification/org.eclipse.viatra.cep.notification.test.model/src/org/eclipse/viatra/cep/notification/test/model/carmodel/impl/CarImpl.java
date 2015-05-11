/**
 */
package org.eclipse.viatra.cep.notification.test.model.carmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.cep.notification.test.model.carmodel.Car;
import org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelPackage;
import org.eclipse.viatra.cep.notification.test.model.carmodel.Engine;
import org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Car</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarImpl#getWheels <em>Wheels</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarImpl#getEngine <em>Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CarImpl extends MinimalEObjectImpl.Container implements Car {
	/**
	 * The cached value of the '{@link #getWheels() <em>Wheels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheels()
	 * @generated
	 * @ordered
	 */
	protected EList<Wheel> wheels;

	/**
	 * The cached value of the '{@link #getEngine() <em>Engine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngine()
	 * @generated
	 * @ordered
	 */
	protected Engine engine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CarmodelPackage.Literals.CAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Wheel> getWheels() {
		if (wheels == null) {
			wheels = new EObjectContainmentWithInverseEList<Wheel>(Wheel.class, this, CarmodelPackage.CAR__WHEELS, CarmodelPackage.WHEEL__CAR);
		}
		return wheels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEngine(Engine newEngine, NotificationChain msgs) {
		Engine oldEngine = engine;
		engine = newEngine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CarmodelPackage.CAR__ENGINE, oldEngine, newEngine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngine(Engine newEngine) {
		if (newEngine != engine) {
			NotificationChain msgs = null;
			if (engine != null)
				msgs = ((InternalEObject)engine).eInverseRemove(this, CarmodelPackage.ENGINE__CAR, Engine.class, msgs);
			if (newEngine != null)
				msgs = ((InternalEObject)newEngine).eInverseAdd(this, CarmodelPackage.ENGINE__CAR, Engine.class, msgs);
			msgs = basicSetEngine(newEngine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarmodelPackage.CAR__ENGINE, newEngine, newEngine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CarmodelPackage.CAR__WHEELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWheels()).basicAdd(otherEnd, msgs);
			case CarmodelPackage.CAR__ENGINE:
				if (engine != null)
					msgs = ((InternalEObject)engine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CarmodelPackage.CAR__ENGINE, null, msgs);
				return basicSetEngine((Engine)otherEnd, msgs);
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
			case CarmodelPackage.CAR__WHEELS:
				return ((InternalEList<?>)getWheels()).basicRemove(otherEnd, msgs);
			case CarmodelPackage.CAR__ENGINE:
				return basicSetEngine(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CarmodelPackage.CAR__WHEELS:
				return getWheels();
			case CarmodelPackage.CAR__ENGINE:
				return getEngine();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CarmodelPackage.CAR__WHEELS:
				getWheels().clear();
				getWheels().addAll((Collection<? extends Wheel>)newValue);
				return;
			case CarmodelPackage.CAR__ENGINE:
				setEngine((Engine)newValue);
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
			case CarmodelPackage.CAR__WHEELS:
				getWheels().clear();
				return;
			case CarmodelPackage.CAR__ENGINE:
				setEngine((Engine)null);
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
			case CarmodelPackage.CAR__WHEELS:
				return wheels != null && !wheels.isEmpty();
			case CarmodelPackage.CAR__ENGINE:
				return engine != null;
		}
		return super.eIsSet(featureID);
	}

} //CarImpl
