package org.eclipse.viatra.cep.jnect.simulator;

import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.BodymodelFactory;
import org.jnect.bodymodel.PositionedElement;
import org.jnect.core.impl.capture.persistence.BasePosture;
import org.jnect.core.impl.capture.persistence.Change;
import org.jnect.core.impl.capture.persistence.Position;

public class ModelUtils {
	public static Body newBody() {
		BodymodelFactory factory = BodymodelFactory.eINSTANCE;

		Body body = factory.createBody();
		body.setHead(factory.createHead());
		body.setCenterHip(factory.createCenterHip());
		body.setSpine(factory.createSpine());
		body.setCenterShoulder(factory.createCenterShoulder());
		body.setLeftShoulder(factory.createLeftShoulder());
		body.setLeftElbow(factory.createLeftElbow());
		body.setLeftWrist(factory.createLeftWrist());
		body.setLeftHand(factory.createLeftHand());
		body.setRightShoulder(factory.createRightShoulder());
		body.setRightElbow(factory.createRightElbow());
		body.setRightWrist(factory.createRightWrist());
		body.setRightHand(factory.createRightHand());
		body.setLeftHip(factory.createLeftHip());
		body.setLeftKnee(factory.createLeftKnee());
		body.setLeftAnkle(factory.createLeftAnkle());
		body.setLeftFoot(factory.createLeftFoot());
		body.setRightHip(factory.createRightHip());
		body.setRightKnee(factory.createRightKnee());
		body.setRightAnkle(factory.createRightAnkle());
		body.setRightFoot(factory.createRightFoot());

		return body;
	}

	public static void setBasePosture(Body body, BasePosture basePosture) {
		setPosition(body.getHead(), basePosture.getHead());
		setPosition(body.getCenterHip(), basePosture.getHipCenter());
		setPosition(body.getSpine(), basePosture.getSpine());
		setPosition(body.getCenterShoulder(), basePosture.getShoulderCenter());
		setPosition(body.getLeftShoulder(), basePosture.getShoulderLeft());
		setPosition(body.getLeftElbow(), basePosture.getElbowLeft());
		setPosition(body.getLeftWrist(), basePosture.getWristLeft());
		setPosition(body.getLeftHand(), basePosture.getHandLeft());
		setPosition(body.getRightShoulder(), basePosture.getShoulderRight());
		setPosition(body.getRightElbow(), basePosture.getElbowRight());
		setPosition(body.getRightWrist(), basePosture.getWristRight());
		setPosition(body.getRightHand(), basePosture.getHandRight());
		setPosition(body.getLeftHip(), basePosture.getHipLeft());
		setPosition(body.getLeftKnee(), basePosture.getKneeLeft());
		setPosition(body.getLeftAnkle(), basePosture.getAnkleLeft());
		setPosition(body.getLeftFoot(), basePosture.getFootLeft());
		setPosition(body.getRightHip(), basePosture.getHipRight());
		setPosition(body.getRightKnee(), basePosture.getKneeRight());
		setPosition(body.getRightAnkle(), basePosture.getAnkleRight());
		setPosition(body.getRightFoot(), basePosture.getFootRight());
	}

	private static void setPosition(PositionedElement bodyPart,
			Position newPosition) {
		bodyPart.setX(newPosition.getX());
		bodyPart.setY(newPosition.getY());
		bodyPart.setZ(newPosition.getZ());
	}

	public static void manipulateModel(Body body, Change change) {
		PositionedElement positionedElement = getPositionedElement(body,
				change.getPositionedElement());
		// System.out.println("changing " +
		// positionedElement.getClass().getSimpleName());
		String attribute = change.getAttribute();
		if (attribute.equalsIgnoreCase("x")) {
			// System.out.println("	in x from " + positionedElement.getX() +
			// " to " + change.getValue());
			positionedElement.setX(change.getValue());
		} else if (attribute.equalsIgnoreCase("y")) {
			// System.out.println("	in y from " + positionedElement.getY() +
			// " to " + change.getValue());
			positionedElement.setY(change.getValue());
		} else if (attribute.equalsIgnoreCase("z")) {
			// System.out.println("	in z from " + positionedElement.getZ() +
			// " to " + change.getValue());
			positionedElement.setZ(change.getValue());
		} else {
			throw new IllegalArgumentException();
		}
	}

	private static PositionedElement getPositionedElement(Body body,
			String bodyPart) {
		if (bodyPart.equalsIgnoreCase("Head")) {
			return body.getHead();
		} else if (bodyPart.equalsIgnoreCase("CenterHip")) {
			return body.getCenterHip();
		} else if (bodyPart.equalsIgnoreCase("Spine")) {
			return body.getSpine();
		} else if (bodyPart.equalsIgnoreCase("CenterShoulder")) {
			return body.getCenterShoulder();
		} else if (bodyPart.equalsIgnoreCase("LeftShoulder")) {
			return body.getLeftShoulder();
		} else if (bodyPart.equalsIgnoreCase("LeftElbow")) {
			return body.getLeftElbow();
		} else if (bodyPart.equalsIgnoreCase("LeftWrist")) {
			return body.getLeftWrist();
		} else if (bodyPart.equalsIgnoreCase("LeftHand")) {
			return body.getLeftHand();
		} else if (bodyPart.equalsIgnoreCase("RightShoulder")) {
			return body.getRightShoulder();
		} else if (bodyPart.equalsIgnoreCase("RightElbow")) {
			return body.getRightElbow();
		} else if (bodyPart.equalsIgnoreCase("RightWrist")) {
			return body.getRightWrist();
		} else if (bodyPart.equalsIgnoreCase("RightHand")) {
			return body.getRightHand();
		} else if (bodyPart.equalsIgnoreCase("LeftHip")) {
			return body.getLeftHip();
		} else if (bodyPart.equalsIgnoreCase("LeftKnee")) {
			return body.getLeftKnee();
		} else if (bodyPart.equalsIgnoreCase("LeftAnkle")) {
			return body.getLeftAnkle();
		} else if (bodyPart.equalsIgnoreCase("LeftFoot")) {
			return body.getLeftFoot();
		} else if (bodyPart.equalsIgnoreCase("RightHip")) {
			return body.getRightHip();
		} else if (bodyPart.equalsIgnoreCase("RightKnee")) {
			return body.getRightKnee();
		} else if (bodyPart.equalsIgnoreCase("RightAnkle")) {
			return body.getRightAnkle();
		} else if (bodyPart.equalsIgnoreCase("RightFoot")) {
			return body.getRightFoot();
		}

		// TODO Throw proper Exception here
		return null;
	}
}
